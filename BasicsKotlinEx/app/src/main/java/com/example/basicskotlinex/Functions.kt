fun main() {
    getName()
    print(square(10))
    showMeUser("Pooja",22,true)
    //OR
    showMeUser(age = 23, isActive = false, name = "Pooja")    //in any order this way
    countAndPrintArgs(2,3,4,5,6,7,8,9)
}

val userName: String = "Allen"

fun getName(): String {
    return "Woody"
}

fun square(number: Int): Int {
    return number * number
}
//OR
fun square2(number: Int): Int = number * number
//OR
fun square3(number: Int) = number * number

fun showMeUser(name:String, age:Int, isActive:Boolean){
    print("Name $name, Age $age, IsActive $isActive")
}
/*

       Types of Arguments
       1. Positional
       2. Default
*/

fun thisFuncShouldStartWithLowerCase() {
    //This is LowerCamelCase
}

fun countAndPrintArgs(vararg number: Int){
    print(number.size)
    for(no in number) println(no)
}



