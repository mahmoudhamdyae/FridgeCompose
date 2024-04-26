package com.mahmoudhamdyae.fridgecompose.auth.data.repository

import com.mahmoudhamdyae.fridgecompose.auth.data.remote.RemoteDataSource
import com.mahmoudhamdyae.fridgecompose.auth.domain.repository.Repository
import com.mahmoudhamdyae.fridgecompose.core.Result
import com.mahmoudhamdyae.fridgecompose.core.error.ServerException
import com.mahmoudhamdyae.fridgecompose.core.error.ServerFailure

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): Repository {

    override suspend fun login(phoneNumber: String, password: String): Result<Unit> {
        return try {
            Result.Success(remoteDataSource.login(phoneNumber, password))
        } catch (error: ServerException) {
            Result.Error(ServerFailure(error.errorMessageModel.error))
        }
    }

    override suspend fun register(
        userName: String,
        phoneNumber: String,
        password: String,
    ): Result<Unit> {
        return try {
            Result.Success(remoteDataSource.register(userName, phoneNumber, password))
        } catch (error: ServerException) {
            Result.Error(ServerFailure(error.errorMessageModel.error))
        }
    }

    override suspend fun signOut() {
    }
}