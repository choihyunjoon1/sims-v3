package co.spoonradio.sims.advice

import co.spoonradio.arch.logger.Logger
import co.spoonradio.sims.exception.ErrorMessage
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.exception.UnauthorizedException
import org.slf4j.MDC
import org.springframework.context.MessageSource
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*
import javax.validation.ConstraintViolationException

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
class GlobalExceptionAdvice(val messageSource: MessageSource) {

    companion object : Logger


    @ExceptionHandler(CredentialsExpiredException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun credentialsExpiredException(e: CredentialsExpiredException): ErrorMessage {
        return ErrorMessage(
            status = HttpStatus.UNAUTHORIZED.value().toString(),
            code = "00004",
            message = messageSource.getMessage("00004", null, Locale.getDefault()),
            errorData = "",
            trace = ""
        ).also {
            MDC.clear()
            e.printStackTrace()
        }
    }

    @ExceptionHandler(GeneralException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun generalException(e: GeneralException) = ErrorMessage(
        status = HttpStatus.NOT_FOUND.value().toString(),
        code = e.code,
        message = messageSource.getMessage(e.code, e.args, Locale.getDefault()),
        errorData = "",
        trace = ""
    ).also {
        MDC.clear()
        e.printStackTrace()
    }


    @ExceptionHandler(UnauthorizedException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun unauthorizedException(e: UnauthorizedException) = ErrorMessage(
        status = HttpStatus.UNAUTHORIZED.value().toString(),
        code = e.code,
        message = messageSource.getMessage(e.code, null, Locale.getDefault()),
        errorData = "",
        trace = ""
    ).also {
        MDC.clear()
        e.printStackTrace()
    }


    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun UnexpectedTypeException(e: ConstraintViolationException): ErrorMessage {
        e.message?.split(": ").let {
            return ErrorMessage(
                status = HttpStatus.BAD_REQUEST.value().toString(),
                code = it!![0],
                message = it[1],
                errorData = "",
                trace = ""
            ).also {
                MDC.clear()
                e.printStackTrace()
            }
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException): ErrorMessage {
        val bindingResult = e.bindingResult
        println(bindingResult.fieldError?.code)

        e.message.split(": ").let {
            return ErrorMessage(
                status = HttpStatus.BAD_REQUEST.value().toString(),
                code = it[0],
                message = it[1],
                errorData = "",
                trace = ""
            ).also {
                MDC.clear()
                e.printStackTrace()
            }
        }
    }

}
