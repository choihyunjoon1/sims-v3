package co.spoonradio.sims.controller

import co.spoonradio.arch.extension.toJson
import co.spoonradio.arch.logger.Logger
import co.spoonradio.sims.common.annotation.TestAnnotation
import co.spoonradio.sims.configuration.properties.sims.SimsEnvInfo
import co.spoonradio.sims.dto.gateway.spooncast.SyncEsBanUser
import co.spoonradio.sims.exception.GeneralException
import co.spoonradio.sims.gateway.client.BalanceApi
import co.spoonradio.sims.gateway.client.SpooncastApi
import co.spoonradio.sims.repository.redis.RedisEventRepository
import co.spoonradio.sims.repository.redis.RedisStoreRepository
import co.spoonradio.sims.repository.users.PostgresUserProfileRepository
import co.spoonradio.sims.service.adminuser.AdminUserInfoManager
import co.spoonradio.sims.service.voc.DefaultBanService
import co.spoonradio.sims.type.event.EventType
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import software.amazon.awssdk.services.ses.SesClient
import software.amazon.awssdk.services.ses.model.*


/**
 * @author whale@spoonradio.co
 * @date   2021/11/01.
 * @Desc
 */
@Api(tags = ["테스트 Controller"])
@RestController
class SampleController(
    val balanceApi: BalanceApi,
    val sesClient: SesClient,
    val storeRepository: RedisStoreRepository,
    val eventRepository: RedisEventRepository,
    val defaultBean: DefaultListableBeanFactory,
    val spooncastApi: SpooncastApi,
    val simsEnvInfo: SimsEnvInfo,
    val userProfileRepository: PostgresUserProfileRepository
) {

    companion object : Logger


    @GetMapping("env")
    fun env() {
        println(simsEnvInfo.toJson())
    }

    @GetMapping("exam")
    fun exam() {
        val str = SyncEsBanUser(
            service = DefaultBanService.SERVICE_NAME,
            target_type = "USER",
            event_type = "RELEAE_BAN",
            target_ids = listOf(1)
        )
        spooncastApi.syncEsBanUser(str)
    }


    @PostMapping(
        "servlet",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun servlet(
        @RequestBody sync: SyncEsBanUser
    ) {
        /*println(req.getHeader("Content-Type"))
        println(req.getHeader("X-Forwarded-Host"))*/
        println(sync)
    }

    @GetMapping("beans")
    fun beans() {
        defaultBean.beanDefinitionNames.forEach { name ->
            println(">>> $name")
            println(defaultBean.getBean(name).javaClass.name)

        }
    }

    @GetMapping(value = ["/redis/rpush"])
    fun redisRPush(): Boolean {
/*
        val usersSnsInfo = UsersSnsInfo(
            sns_type = "facebook",
            sns_id = "101000000123443",
            id = 11023045,
            tag = "sample"
        )

        return eventRepository.accountBanEvent(usersSnsInfo, EventType.CREATED.name)
*/
        userProfileRepository.getUserSnsInfo(1).let {
            eventRepository.accountBanEvent(it, EventType.CREATED.name)
        }
        return true

    }

    @GetMapping(value = ["/redis"])
    fun redisPost(): String? {
        storeRepository.add("64862", "j444f")
        return storeRepository.get("64862")
    }

    @GetMapping(value = ["/redis/get"])
    fun redisGet(): String? {
        return storeRepository.get("648612")
    }


    @ApiOperation(value = "MAIN", notes = "")
    @GetMapping(value = ["/hello"])
    fun authHello(): String {
        //eyJ0eXBlIjoiSldUIiwiYWxnb3JpdGhtIjoiSFMyNTYiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6IndoYWxlQHNwb29ucmFkaW8uY28iLCJleHAiOjE2MzY3MDkzMzh9.rt-XCGjkBSGADwz5vtXm4iZIJGPNjv318kBsy5X2lpQ
        return "TEST"
    }


    @ApiOperation(value = "EXCEPTION 테스트", notes = "EXCEPTION 발생 테스트")
    @GetMapping(value = ["/exception"])
    fun exception() {
        throw GeneralException("00001")
    }



    @ApiOperation(value = "EMAIL 테스트", notes = "EXCEPTION 발생 테스트")
    @GetMapping(value = ["/ses"])
    fun ses(): String {
        //amazonSimpleEmailServiceAsync
        val FROM: String = "martin@spoonradio.co";
        val TO: String = "whale@spoonradio.co";
        val SUBJECT: String = "Amazon SES test (AWS SDK for Java)";
        val HTMLBODY: String = """
                                    <h1>Amazon SES test (AWS SDK for Java)</h1>
                                    <p>This email was sent with <a href='https://aws.amazon.com/ses/'>
                                    Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>
                                    AWS SDK for Java</a>
        """

        val subject: Content = Content.builder().data(SUBJECT).build()
        val content: Content = Content.builder().data("mail test").build()
        val message = Message.builder().subject(subject).body(Body.builder().text(content).build()).build()
        sesClient.sendEmail(
            SendEmailRequest.builder().destination(Destination.builder().toAddresses(AdminUserInfoManager.getUserInfo().email).build())
            .message(message).source(FROM).build())

        return "OK"
    }


    @ApiOperation(value = "AOP 동작 테스트", notes = "TestAnnotation이며 동작테스트를 진행한다.")
    @TestAnnotation
    @GetMapping(value = ["/aop"])
    fun aop(): String {
        return "AOP"
    }

    @ApiOperation(value = "외부 API 접근 테스트", notes = "Balance API 에서 5번 사용자의 Balance를 가져온다. (DEV)")
    @GetMapping(value = ["/balance/api/{userId}"])
    fun api(@PathVariable("userId") userId: Int) = balanceApi.getUserBalance(userId)


    @ApiOperation(value = "Log 테스트", notes = "INFO / DEBUG / ERROR 로그 출력 테스트")
    @GetMapping(value = ["/log"])
    fun log() {
        logger.info("INFO")
        logger.debug("DEBUG")
        logger.error("ERROR")
    }


//    @ApiOperation(value = "Log 테스트", notes = "INFO / DEBUG / ERROR 로그 출력 테스트")
//    @GetMapping(value = ["/s3"])
//    fun s3(@RequestParam("file") file: MultipartFile ) {
//
//        logger.info("INFO")
//        logger.debug("DEBUG")
//        logger.error("ERROR")
//    }

}