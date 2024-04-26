package com.mahmoudhamdyae.fridgecompose.auth.domain.repository

import com.mahmoudhamdyae.fridgecompose.core.Result

interface Repository {

    suspend fun login(phoneNumber: String, password: String): Result<Unit>
    suspend fun register(
        userName: String,
        phoneNumber: String,
        password: String,
    ): Result<Unit>
    suspend fun signOut()
}