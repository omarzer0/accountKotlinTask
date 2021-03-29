import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

var account: Account? = null
val scanner = Scanner(System.`in`)
var deposit: Deposit? = null
var withdraw: Withdraw? = null
var lastTransaction = -1

fun main(args: Array<String>) {
    doFunctionality(display())
}

fun display(): Int {
    println(
        "- Press 1 to enter account details\n" +
                "- Press 2 to deposit\n" +
                "- Press 3 to withdraw\n" +
                "- Press 4 to show current balance\n" +
                "- Press 5 to cancel last transaction\n" +
                "- Press 6 to exit"
    )
    return try {
        scanner.nextInt()
    } catch (e: Exception) {
        // if any input error exit the program
        6
    }
}

fun doFunctionality(number: Int) {
    when (number) {
        1 -> enterNewAccount()
        2 -> deposit()
        3 -> withdraw()
        4 -> showCurrentBalance()
        5 -> cancelTransaction()
        6 -> exitProgram()
        else -> {
            println("Wrong input please try again!")
            exitProgram()
        }
    }
}


fun enterNewAccount() {
    print("enter the account number: ")
    val accountNumber = scanner.nextInt()
    print("enter the account balance: ")
    val balance = scanner.nextDouble()
    print("enter the owner name: ")
    val ownerName = scanner.next()
    account = Account(accountNumber, ownerName, balance)
    doFunctionality(display())
}


fun deposit() {
    print("enter amount of money: ")
    val amount = scanner.nextDouble()
    deposit = Deposit(amount)
    if (account != null) {
        deposit!!.deposit(account!!)
        lastTransaction = 2
    } else {
        println("please enter the account details first and try again")
    }
    doFunctionality(display())
}

fun withdraw() {
    print("enter amount of money: ")
    val amount = scanner.nextDouble()
    withdraw = Withdraw(amount)
    if (account != null) {
        withdraw!!.withdraw(account!!)
        lastTransaction = 3
    } else {
        println("please enter the account details first and try again")
    }
    doFunctionality(display())
}

fun showCurrentBalance() {
    print("enter currencyType 'U' for USD or 'E' for EURO: ")
    val currencyType = scanner.next().toUpperCase()
    val balanceInquiry = BalanceInquiry(currencyType)
    if (account != null) {
        balanceInquiry.printAccountBalance(account!!)
    } else {
        println("please enter the account details first and try again")
    }
    doFunctionality(display())
}

fun cancelTransaction() {
    when (lastTransaction) {
        2 -> account?.let { deposit!!.cancelTransaction(it) }
        3 -> account?.let { withdraw!!.cancelTransaction(it) }
        else ->{
            println("No transaction is done yet!")
        }
    }
    doFunctionality(display())
}

fun exitProgram() {
    exitProcess(0)
}




