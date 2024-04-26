package com.mahmoudhamdyae.fridgecompose.auth.presentation

sealed class ValidationEvent {
    data object Success: ValidationEvent()
}