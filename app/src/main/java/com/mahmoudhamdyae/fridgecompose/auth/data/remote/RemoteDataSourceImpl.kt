package com.mahmoudhamdyae.fridgecompose.auth.data.remote

import com.mahmoudhamdyae.fridgecompose.core.ApiConstants
import com.mahmoudhamdyae.fridgecompose.core.error.ServerException
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

class RemoteDataSourceImpl(
    private  val client: HttpClient
) : RemoteDataSource {

    private suspend fun checkResponse(response: HttpResponse) {
        if (response.status == HttpStatusCode.NotFound) {
            throw ServerException(errorMessageModel = response.body())
        }
    }

    override suspend fun login(phoneNumber: String, password: String) {
        val response: HttpResponse = client.post(ApiConstants.LOGIN_PATH) {
            url.parameters.apply {
                append("phone", phoneNumber)
                append("password", password)
            }
        }
        checkResponse(response)
    }

    override suspend fun register(
        userName: String,
        phoneNumber: String,
        password: String,
    ) {
        val response: HttpResponse = client.post(ApiConstants.REGISTER_PATH) {
            url.parameters.apply {
                append("name", userName)
                append("phone", phoneNumber)
                append("password", password)
                append("grade", "المرحلة المتوسطة")
                append("group", "الصف السادس")
            }
        }
        checkResponse(response)
    }
}