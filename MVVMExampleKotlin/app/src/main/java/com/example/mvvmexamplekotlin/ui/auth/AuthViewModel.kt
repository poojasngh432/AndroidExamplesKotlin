package com.example.mvvmexamplekotlin.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmexamplekotlin.data.repositories.UserRepository
import com.example.mvvmexamplekotlin.util.ApiException
import com.example.mvvmexamplekotlin.util.Coroutines

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {
    //to get email and password from the ui
    //<data> created in activity_login layout file, now we can use viewmodel to send the input values to these variables - email and pwd
    //AuthViewModel will interact with the repository to perform the actual login operation

    //Here we will get the AuthResponse directly

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    //to save the user changes in the local db
    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            //display an error msg
            authListener?.onFailure("Invalid username or password")
            return
        }

        Coroutines.main{
            try {
                val authresponse = repository.userLogin(email!!, password!!)
                //let is to make sure user is not null
                authresponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)  //to save to db
                    return@main
                }
                //incase the user is null, we can call onFailure
                authListener?.onFailure(authresponse.message!!) //return@main is called so that this line is not called even when there is a success
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }

        }


    }

}