class BalanceInquiry(private var currencyType: String) : Transaction() {

    override fun execute(account: Account): Double {
        return when (currencyType) {
            "E" -> account.balance * 0.85
            else -> account.balance
        }
    }

    fun printAccountBalance(account: Account) {
        val balance = execute(account)
        if (currencyType != "E") currencyType = "USD"
        else currencyType = "EURO"
        println("Your balance is $balance $currencyType")
    }
}