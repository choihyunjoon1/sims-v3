package co.spoonradio.sims.configuration.database

import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform
import javax.transaction.TransactionManager

import javax.transaction.UserTransaction

open class AtomikosJtaPlatform : AbstractJtaPlatform() {
    companion object {
        var txManager:TransactionManager? = null
        var transaction: UserTransaction? = null
    }

    override fun locateTransactionManager(): TransactionManager? {
        return txManager
    }

    override fun locateUserTransaction(): UserTransaction? {
        return transaction
    }
}
