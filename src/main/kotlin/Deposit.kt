class Deposit(private val amount: Double) : Transaction(), Rollback {


    fun deposit(account: Account) {
        account.balance = account.balance + amount
        println("Your balance is ${execute(account)} USD")
    }

    override fun execute(account: Account): Double {
        return account.balance
    }

    override fun cancelTransaction(account: Account) {
        account.balance = account.balance - amount
        println("Your balance is ${execute(account)} USD")
    }

}