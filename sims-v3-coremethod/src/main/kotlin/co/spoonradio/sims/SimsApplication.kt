package co.spoonradio.sims

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.transaction.annotation.EnableTransactionManagement


@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = ["co.spoonradio.sims"])
@EnableFeignClients
@ConfigurationPropertiesScan
class SimsApplication

fun main(args: Array<String>) {
    runApplication<SimsApplication>(*args)
}
fun test(){
    println("테스트용입니다.")
}
