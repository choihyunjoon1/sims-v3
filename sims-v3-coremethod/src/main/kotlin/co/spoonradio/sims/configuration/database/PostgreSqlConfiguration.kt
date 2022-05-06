package co.spoonradio.sims.configuration.database

import co.spoonradio.sims.configuration.properties.database.PostgreSqlInfo
import com.atomikos.jdbc.AtomikosDataSourceBean
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultConfiguration
import org.postgresql.xa.PGXADataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource


/**
 * @author whale@spoonradio.co
 * @date   2021/11/02.
 * @Desc
 */
@Configuration
class PostgreSqlConfiguration(val postgreSqlInfo: PostgreSqlInfo) {

//    @Bean(name = ["postgresDataSource"])
//    fun postgresDataSource() = DataSourceBuilder.create().type(HikariDataSource::class.java)
//                                .url(postgreSqlInfo.url)
//                                .username(postgreSqlInfo.username)
//                                .password(postgreSqlInfo.password)
//                                .driverClassName(postgreSqlInfo.driverClassName)
//                                .build()
//
//    @Bean(name=["postgresLlazyConnectionDataSource"])
//    fun postgresLlazyConnectionDataSource(@Qualifier("postgresDataSource") postgresDataSource:DataSource) = LazyConnectionDataSourceProxy(postgresDataSource)

    @Bean(name=["postgresDataSource"])
    fun postgresDataSource(): DataSource {

        val postgresDataSource = PGXADataSource()
        postgresDataSource.setUrl(postgreSqlInfo.url)
        postgresDataSource.user = postgreSqlInfo.username
        postgresDataSource.password = postgreSqlInfo.password

        val atomikosDataSourceBean = AtomikosDataSourceBean()
        atomikosDataSourceBean.xaDataSource = postgresDataSource
        atomikosDataSourceBean.uniqueResourceName = "main"
        return atomikosDataSourceBean

    }

    @Bean(name = ["postgresTxManager"])
    fun postgresTxManager(@Qualifier("postgresDataSource") postgresDataSource: DataSource): DataSourceTransactionManager? {
        return DataSourceTransactionManager(postgresDataSource)
    }

    @Bean(name = ["postgreSqlDslContext"])
    fun dslContext(@Qualifier("postgresDataSource") postgresDatasource : DataSource): DSLContext {
        return JooqAutoConfiguration.DslContextConfiguration().dslContext(
            DefaultConfiguration().set(SQLDialect.POSTGRES)
                .set(
                    DataSourceConnectionProvider(
                        TransactionAwareDataSourceProxy(postgresDatasource)
                    )
                )
        )
    }

}