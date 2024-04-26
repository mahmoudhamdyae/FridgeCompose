package com.mahmoudhamdyae.fridgecompose.core

import com.mahmoudhamdyae.fridgecompose.core.error.Failure

sealed class Result<T> {
    class Success<T>(val data: T) : Result<T>()
    class Error<T>(val failure: Failure) : Result<T>()
}