abstract class Transaction(transactionId:Long = 1){

    abstract fun execute(account: Account): Double
}