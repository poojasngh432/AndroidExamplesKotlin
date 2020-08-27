package com.example.mvvmexamplekotlin.ui.auth

import androidx.lifecycle.LiveData
import com.example.mvvmexamplekotlin.data.db.entities.User

interface AuthListener {

    //to get a callback from AuthViewModel to LoginActivity

    fun onStarted()
       //to display a progress bar

    fun onSuccess(user: User)

    fun onFailure(message: String)

}