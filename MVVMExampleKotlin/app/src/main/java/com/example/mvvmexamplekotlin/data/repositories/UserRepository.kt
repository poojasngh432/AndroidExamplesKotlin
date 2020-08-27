package com.example.mvvmexamplekotlin.data.repositories

import com.example.mvvmexamplekotlin.data.db.AppDatabase
import com.example.mvvmexamplekotlin.data.db.entities.User
import com.example.mvvmexamplekotlin.data.network.MyApi
import com.example.mvvmexamplekotlin.data.network.SafeApiRequest
import com.example.mvvmexamplekotlin.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {
    //LoginActivity will interact with AuthViewModel
    //and AuthViewModel will interact with UserRepository

    //soo we will call this function from ViewModel
    suspend fun userLogin(email: String, password: String): AuthResponse {

        return apiRequest { api.userLogin(email, password) }

    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()
}