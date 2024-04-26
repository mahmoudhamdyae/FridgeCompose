package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: Int? = null
)