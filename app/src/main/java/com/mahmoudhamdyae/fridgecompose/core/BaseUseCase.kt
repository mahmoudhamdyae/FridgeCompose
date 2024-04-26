package com.mahmoudhamdyae.fridgecompose.core

import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.LoginUseCase
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.RegisterUseCase
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.SignOutUseCase
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidateEmail
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidatePassword
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidateRepeatedPassword
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidateUserName

data class BaseUseCase (
    val loginUseCase: LoginUseCase,
    val signOutUseCase: SignOutUseCase,
    val registerUseCase: RegisterUseCase,
    val validateEmail: ValidateEmail,
    val validatePassword: ValidatePassword,
    val validateRepeatedPassword: ValidateRepeatedPassword,
    val validateUserName: ValidateUserName,
)