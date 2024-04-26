package com.mahmoudhamdyae.fridgecompose.auth.data.remote

interface RemoteDataSource {

    suspend fun login(phoneNumber: String, password: String)
    suspend fun register(
        userName: String,
        phoneNumber: String,
        password: String,
    )
}