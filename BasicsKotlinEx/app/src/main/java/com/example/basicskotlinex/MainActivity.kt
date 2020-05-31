package com.example.basicskotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Lists
        var listOfWords = listOf<String>("Hello", "World", "kermit")   //Immutable. can't add later to this list
        var mutableListOfWords = mutableListOf<String>("In","the","planet")    //Mutable. can add later
        var arrListOf = arrayListOf<String>("M","N","O","P")
        mutableListOfWords.add("H")

        //HashMap
        val hashMapOfNames = hashMapOf("name" to "Pooja", 1 to 20)
        hashMapOfNames["One"] = "Two"

        //Arrays
        val numbers = arrayOf(1, 2, 3, 4, 5)
        val name = arrayOf("A", "B", "C", "D", 5)
        val nameString = arrayOf<String>("E", "F", "G", "H")

        /* [vararg]: when you can have n no. of arguments inside any function
        */

        //Array Constructor
        val num = Array(6, { i -> i *2 })
        val numArr = intArrayOf(1, 2, 3, 4, 5, 6, 7)

        //Loops
        nameString.forEach {
                                               //for each loop
        }
        hashMapOfNames.forEach { (p, p2) ->
            print("" + p + p2)
        }
        numArr.forEach {
            print(it)
        }
        for (num in numArr){   //another form of for each
            print(num)
        }
        for(x in 0..10){  //10 is inclusive
            print(x)
        }
        for(x in 0 until 10){  //10 is exclusive
            print(x)
        }
        for(x in 0 until 10 step 2){  //prints 0 2 4 6 8
            print(x)
        }
        for(x in 10 downTo 0 step 2){  //prints 10 8 6 4 2 0
            print(x)
        }

        val any:Any = "Tom"
        if(any is String){
            any.length
        }

        //when
        when(any){
            "Jerry" -> {

            }
            "Adam" -> {

            }
            "Tom" -> {

            }
            "Martha" -> {

            }
            else -> {

            }
        }
    }
}
