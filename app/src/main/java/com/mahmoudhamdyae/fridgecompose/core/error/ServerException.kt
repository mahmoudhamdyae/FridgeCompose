package com.mahmoudhamdyae.fridgecompose.core.error

class ServerException(
    val errorMessageModel: ErrorMessageModel
): Exception()