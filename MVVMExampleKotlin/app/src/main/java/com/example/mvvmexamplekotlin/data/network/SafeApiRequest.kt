package com.example.mvvmexamplekotlin.data.network

import com.example.mvvmexamplekotlin.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeApiRequest {

    //we'll use this fun to create Api request
    //UserRepository class will extend SafeApiRequest class
    suspend fun<T:Any> apiRequest(call: suspend() -> Response<T>) : T{
        val response = call.invoke()

        if(response.isSuccessful){
            return response.body()!! // !! is to ,ake sure it isn't null
        }else{
            val error = response.errorBody()?.string()
            val message = StringBuilder()

            error?.let {
                //we'll convert error to a JSON object here
                try {
                    message.append(JSONObject(it).getString("message"))

                }catch(e: JSONException){
                   message.append("\n")
                }
            }
            message.append("Error code: ${response.code()}")

            throw ApiException(message.toString())
        }
    }

}
