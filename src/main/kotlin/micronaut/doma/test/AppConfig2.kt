package micronaut.doma.test

import io.micronaut.context.ApplicationContext
import org.seasar.doma.jdbc.Config
import org.seasar.doma.jdbc.ConfigSupport
import org.seasar.doma.jdbc.Naming
import org.seasar.doma.jdbc.dialect.PostgresDialect
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource
import org.seasar.doma.jdbc.tx.LocalTransactionManager
import javax.inject.Singleton
import javax.sql.DataSource

@Singleton
class AppConfig2 : Config {

    companion object {

        val dataSource = LocalTransactionDataSource(ApplicationContext.run().getBean(DataSource::class.java))

        val transactionManager = LocalTransactionManager(
                dataSource.getLocalTransaction(ConfigSupport.defaultJdbcLogger))

    }

    override fun getDataSource() = AppConfig2.dataSource

    override fun getTransactionManager() = AppConfig2.transactionManager

    override fun getDialect() = PostgresDialect()

    override fun getNaming() = Naming.SNAKE_LOWER_CASE
}