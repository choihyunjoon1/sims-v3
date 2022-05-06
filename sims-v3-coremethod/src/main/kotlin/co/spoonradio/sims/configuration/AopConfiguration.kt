package co.spoonradio.sims.configuration

import co.spoonradio.arch.extension.toJson
import co.spoonradio.sims.common.`object`.ExcludeUrl
import co.spoonradio.sims.dto.common.AuditLog
import co.spoonradio.sims.dto.common.RequestParameter
import co.spoonradio.sims.dto.request.excel.RequestExcel
import co.spoonradio.sims.dto.response.adminuser.AdminUserMenuGrant
import co.spoonradio.sims.exception.UnauthorizedException
import co.spoonradio.sims.repository.common.log.LogRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.MDC
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.time.ZoneId
import java.time.ZonedDateTime
import javax.servlet.http.HttpServletRequest


/**
 * @author whale@spoonradio.co
 * @date   2021/11/04.
 * @Desc https://gaemi606.tistory.com/m/entry/Spring-Boot-AOP%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%B4-%EB%A1%9C%EA%B7%B8-%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0-REST-API
 *
 */
@Configuration
@Aspect
class AopConfiguration(
    val mysqlLogRepository: LogRepository
) {

    @Around("@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller) )")
    fun controllerBeforeProcessAop(joinPoint: ProceedingJoinPoint): Any? {



        var httpRequest: HttpServletRequest = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        var grantApiUrl = httpRequest.requestURI.replace("/v3/sims", "")

        val methodSignature = joinPoint.signature as MethodSignature
        val method = methodSignature.method
        val args = joinPoint.args


        val requestParameter = RequestParameter()
        method.parameters.forEachIndexed { index, param ->
            param.getAnnotation(ModelAttribute::class.java)?.let {
                requestParameter.query_params.add(args[index].toString())
            }

            param.getAnnotation(RequestParam::class.java)?.let {
                requestParameter.query_params.add(args[index].toString())
            }

            param.getAnnotation(RequestBody::class.java)?.let {
                if(args[index] is RequestExcel){
                    val requestExcel = args[index] as RequestExcel
                    requestParameter.download_reason = requestExcel.download_reason
                }
                requestParameter.request_body.add(args[index].toJson())
            }

            param.getAnnotation(PathVariable::class.java)?.let {
                grantApiUrl = grantApiUrl.replace(args[index].toString(), "{#id}")
                requestParameter.path_params.add(args[index].toJson())
            }
        }

        /** MENU 권한 체크 */
        if(!ExcludeUrl.isMatch(grantApiUrl)){
            val grantMenu = AdminUserInfoManager.getGrantInfo()
            if(!grantMenu.containsKey(grantApiUrl + httpRequest.method)) throw UnauthorizedException("00016")
            MDC.put("UNMASKING", (grantMenu.get(grantApiUrl + httpRequest.method)?.get(0) as AdminUserMenuGrant).unmasking.toString())
            /** TODO : SubMenuId / SubMenuName 추출 */
            /*MDC.put("SUB_MENU_ID", (grantMenu.get(grantApiUrl + httpRequest.method)?.get(0) as AdminUserMenuGrant).sub_menu_id.toString())
            MDC.put("SUB_MENU_NAME", (grantMenu.get(grantApiUrl + httpRequest.method)?.get(0) as AdminUserMenuGrant).en_name)*/

        }

        val proceedReturnValue = joinPoint.proceed()

        /** AuuditLog 적재 */
        this.createAuditLog(httpRequest, requestParameter)

        return proceedReturnValue
    }



    fun createAuditLog(httpRequest: HttpServletRequest, requestParameter: RequestParameter) {
        mysqlLogRepository.createAuditLog(
            AuditLog(
                access_ip = httpRequest.remoteAddr,
                access_agent = httpRequest.getHeader("User-Agent"),
                api_url = httpRequest.requestURI,
                api_method = httpRequest.method,
                api_detail = "",
                req_parameter = requestParameter.toJson(),
                sub_menu_id = null,
                sub_menu_name = "",
                user_id = AdminUserInfoManager.getUserInfo().userId,
                user_name = AdminUserInfoManager.getUserInfo().userName,
                result_cd = "AR001",
                create_dt = ZonedDateTime.now(ZoneId.of("UTC")),
                download_reason = requestParameter.download_reason,
                en_api_detail = "",
                en_sub_menu_name = ""
            )
        )
    }

   /* @Around("@annotation(co.spoonradio.sims.common.annotation.TestAnnotation)")
    fun testAnnotation(joinPoint: ProceedingJoinPoint) {
        println("AOP:testAnnotation:START")
        joinPoint.proceed()
        println("AOP:testAnnotation:END")
        //TODO : MDC Cleaar
    }*/
}