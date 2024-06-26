package com.mahmoudhamdyae.fridgecompose.auth.presentation

data class AuthFormState(
    val userName: String = "",
    val userNameError: Int? = null,
    val email: String = "",
    val emailError: Int? = null,
    val password: String = "",
    val passwordError: Int? = null,
    val repeatedPassword: String = "",
    val repeatedPasswordError: Int? = null,
)
