package com.example.mvvmexamplekotlin.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//we use an object so that we can directly call the functions with the help of this coroutines object(similar to static in java)

object Coroutines {

    //we can use main to call our userLogin inside AuthViewModel

    //this is a fun
    //this fun is taking another fun as a parameter and we're executing the func inside it ( work() is execution )
    fun main(work: suspend (() -> Unit))  =  //Unit is eq to void in java
    CoroutineScope(Dispatchers.Main).launch {
        work()   //we'll perform the work
    }
}
