package com.example.mvvmexamplekotlin.data.network.responses

import com.example.mvvmexamplekotlin.data.db.entities.User

data class AuthResponse (
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)