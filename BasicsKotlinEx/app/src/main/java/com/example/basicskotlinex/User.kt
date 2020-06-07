package com.example.basicskotlinex

fun main(){

    val user: User = User()  //This is an object
    user.email

    val account = Account()
    account.deposit(100f)
    account.withDraw(150f)
    account.withDraw(150f)

    val account2 = Account(1234)


}

class User{
    var name:String = ""
    var mobile: Int = 1
    var gender: String = ""
    var email: String = ""
    var bio: String = ""

    fun checkEmail():Boolean{
        return email.isNotEmpty()
    }
}

class Account{
    // Primary Constructor defined in class
    // class Account(var accNo: Int, var name: String, var account: Float){  }
    //then the object of this type of class will be defined as
    // val account = Account(1234,"Pooja",1000f)

    var accNo: Int = 0
    var name: String? = null
    var amount:Float = 0F

    //this keyword - points to the current receiver

    //Constructor - It is a function with same name as Class
    /*
    It is used to initialize the class
    1. Primary Constr - Only 1
    2. Secondary Const - Multiple Sec Constr
     */


    fun Account(accNo: Int,name: String,amount: Float){
        this.accNo = accNo
        this.name = name
        this.amount = amount
    }

    //Secondary Constr
    constructor(accNo: Int){
        this.accNo = accNo
        name = "Default"
        amount = 0f
    }
    constructor(accNo: Int,name: String){
        this.accNo = accNo
        this.name = name
        this.amount = 0f
    }

    constructor()

    //member functional
    fun deposit(money:Float){
        amount+= money
        print(amount)
    }

    fun withDraw(money:Float){
        if(amount < money){
            print("Not sufficient funds")
        }else{
            amount -= money
        }
    }

}