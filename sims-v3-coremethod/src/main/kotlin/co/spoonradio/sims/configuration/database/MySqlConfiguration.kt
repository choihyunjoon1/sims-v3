package co.spoonradio.sims.configuration.database

import co.spoonradio.sims.configuration.properties.database.MySqlInfo
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
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource


/**
 * @author whale@spoonradio.co
 * @date   2021/11/02.
 * @ref  =
 *  https://ellune.tistory.com/41
 *  https://titanwolf.org/Network/Articles/Article?AID=400b901e-d20d-42d0-aa75-73bd9c7c4c1a
 */
@Configuration
class MySqlConfiguration(val mysqlInfo: MySqlInfo) {

    @Primary
    @Bean(name = ["mysqlDataSource"])
    fun mysqlDataSource(): DataSource {
//        val datasource = DataSourceBuilder.create().type(HikariDataSource::class.java)
//            .url(mysqlInfo.url)
//            .username(mysqlInfo.username)
//            .password(mysqlInfo.password)
//            .driverClassName(mysqlInfo.driverClassName)
//            .build()
        val mysqlXADataSource = MysqlXADataSource()
        mysqlXADataSource.setUrl(mysqlInfo.url)
        mysqlXADataSource.user = mysqlInfo.username
        mysqlXADataSource.password = mysqlInfo.password

        val atomikosDataSourceBean = AtomikosDataSourceBean()
        atomikosDataSourceBean.xaDataSource = mysqlXADataSource
        atomikosDataSourceBean.uniqueResourceName = "mysql"
        return atomikosDataSourceBean

    }

    @Bean(name = ["mysqlTxManager"])
    fun mysqlTxManager(@Qualifier("mysqlDataSource") mysqlDataSource: DataSource): DataSourceTransactionManager? {
        return DataSourceTransactionManager(mysqlDataSource)
    }

    @Bean(name = ["mysqlDslContext"])
    fun dslContext(@Qualifier("mysqlDataSource") mysqlDataSource: DataSource): DSLContext {
        return JooqAutoConfiguration.DslContextConfiguration().dslContext(
            DefaultConfiguration().set(SQLDialect.MYSQL)
                .set(
                    DataSourceConnectionProvider(
                        TransactionAwareDataSourceProxy(mysqlDataSource)
                    )
                )
        )
    }
}
