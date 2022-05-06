package co.spoonradio.sims.configuration.database

import co.spoonradio.sims.configuration.database.properties.BillingInfo
import com.atomikos.jdbc.AtomikosDataSourceBean
import com.mysql.cj.jdbc.MysqlXADataSource
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource

@Configuration
class BillingConfiguration(val billingInfo: BillingInfo) {

    @Bean(name=["billingDataSource"])
    fun billingDataSource(): DataSource {
//        return DataSourceBuilder.create().type(HikariDataSource::class.java)
//            .url(billingInfo.url)
//            .username(billingInfo.username)
//            .password(billingInfo.password)
//            .driverClassName(billingInfo.driverClassName)
//            .build()

        val mysqlXADataSource = MysqlXADataSource()
        mysqlXADataSource.setUrl(billingInfo.url)
        mysqlXADataSource.user = billingInfo.username
        mysqlXADataSource.password = billingInfo.password
        val atomikosDataSourceBean = AtomikosDataSourceBean()
        atomikosDataSourceBean.xaDataSource = mysqlXADataSource
        atomikosDataSourceBean.uniqueResourceName = "billing"
        return atomikosDataSourceBean

    }

    @Bean(name=["billingTxManager"])
    fun postgresTxManager(@Qualifier("billingDataSource") billingDataSource: DataSource): DataSourceTransactionManager? {
        return DataSourceTransactionManager(billingDataSource)
    }

    @Bean(name = ["billingDslContext"])
    fun dslContext(@Qualifier("billingDataSource") billingDataSource : DataSource): DSLContext {
        return JooqAutoConfiguration.DslContextConfiguration().dslContext(
            DefaultConfiguration().set(SQLDialect.MYSQL)
                .set(
                    DataSourceConnectionProvider(
                        TransactionAwareDataSourceProxy(billingDataSource)
                    )
                )
        )
    }
}