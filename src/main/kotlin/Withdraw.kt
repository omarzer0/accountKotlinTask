class Withdraw(private val amount: Double) : Transaction(), Rollback {

    var isDrawDone = false

    fun withdraw(account: Account) {
        if (account.balance >= amount) {
            account.balance = account.balance - amount
            isDrawDone = true
        }else{
            println("You do not have enough money!")
        }
        println("Your balance is ${execute(account)} USD")
    }

    override fun execute(account: Account): Double {
        return account.balance
    }

    override fun cancelTransaction(account: Account) {
        if (isDrawDone){
            account.balance = account.balance + amount
            isDrawDone = false
        }
        println("Your balance is ${execute(account)} USD")
    }

}