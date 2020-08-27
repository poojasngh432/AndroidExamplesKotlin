package com.example.mvvmexamplekotlin.data.network

import com.example.mvvmexamplekotlin.data.network.responses.AuthResponse
import net.simplifiedcoding.mvvmsampleapp.data.network.NetworkConnectionInterceptor
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    //we will send email and password to ViewModel
    //then the ViewModel will interact with the repository to interact with the back-end web server
    //and the web server will check if the email and pwd are valid or not and return the response

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(  //a suspend fun can be paused or resumed at a later time
        @Field("email") email: String,   //so suspend functions can execute a long running operations and wait for it to complete without blocking
        @Field("password") password: String
    ): Response<AuthResponse>

    @FormUrlEncoded
    @POST("signup")
    fun userSignup(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>

//    @GET("quotes")
//    fun getQuotes(): Response<QuotesResponse>

    companion object {
        operator fun invoke(): MyApi {

            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}