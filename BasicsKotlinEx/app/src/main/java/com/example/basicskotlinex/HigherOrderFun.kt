package com.example.basicskotlinex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HigherOrderFun : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getUser("Singh",{

        })
        getUser2("Singh", {

        })
    }

    /*
    Higher Order Functions - functions that are passed as an argument
    Unit - means doNothing function will return nothing
     */
    fun getUser(name:String,doNothing:() -> Unit): String{
        //to call that function
        //doNothing.invoke()   OR  doNothing()
        doNothing()
        return "Pooja $name"
    }
    fun getUser2(name:String,doNothing2:(isActive: Boolean) -> Unit): String{
        //to call that function
        //doNothing.invoke()   OR  doNothing()
        if(name == "Singh"){
            doNothing2(true)
        }else{
            doNothing2(false)
        }
        return "Pooja $name"
    }
}
