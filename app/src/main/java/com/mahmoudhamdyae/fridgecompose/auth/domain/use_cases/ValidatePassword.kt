package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

import com.mahmoudhamdyae.fridgecompose.R
import com.mahmoudhamdyae.fridgecompose.core.ext.passwordErrorMessage

class ValidatePassword {

    operator fun invoke(password: String, isLogIn: Boolean = false): ValidationResult {
        val passwordErrorMessage = password.passwordErrorMessage()
        return if (passwordErrorMessage == null) {
            ValidationResult(
                successful = true,
            )
        } else if (passwordErrorMessage == R.string.empty_password_error) {
            ValidationResult(
                successful = false,
                errorMessage = passwordErrorMessage
            )
        } else if (!isLogIn) {
            ValidationResult(
                successful = false,
                errorMessage = passwordErrorMessage
            )
        } else {
            ValidationResult(
                successful = true
            )
        }
    }
}