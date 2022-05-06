package co.spoonradio.sims.configuration.database

import com.atomikos.icatch.jta.UserTransactionImp
import com.atomikos.icatch.jta.UserTransactionManager
import org.springframework.context.annotation.*
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.jta.JtaTransactionManager
import javax.transaction.TransactionManager
import javax.transaction.UserTransaction


@Configuration
@ComponentScan
@EnableTransactionManagement
class AtomikosJtaConfiguration {
    companion object {
        @Bean
        fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer? {
            return PropertySourcesPlaceholderConfigurer()
        }
    }

    @Bean(name = ["userTransaction"])
    fun userTransaction(): UserTransaction {
        val userTransactionImp = UserTransactionImp()
        userTransactionImp.setTransactionTimeout(10000)
        return userTransactionImp
    }

    @Bean(name = ["atomikosTransactionManager"], initMethod = "init", destroyMethod = "close")
    fun atomikosTransactionManager(): TransactionManager {
        val userTransactionManager = UserTransactionManager()
        userTransactionManager.forceShutdown = false

        AtomikosJtaPlatform.txManager = userTransactionManager
        return userTransactionManager
    }

    @Primary
    @Bean(name = ["transactionManager"])
    @DependsOn("userTransaction", "atomikosTransactionManager")
    fun transactionManager(): PlatformTransactionManager? {
        val userTransaction = userTransaction()
        AtomikosJtaPlatform.transaction = userTransaction
        val atomikosTransactionManager: TransactionManager = atomikosTransactionManager()
        return JtaTransactionManager(userTransaction, atomikosTransactionManager)
    }
}