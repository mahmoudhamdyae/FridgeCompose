package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

import com.mahmoudhamdyae.fridgecompose.R
import com.mahmoudhamdyae.fridgecompose.core.ext.isValidEmail

class ValidateEmail {

    operator fun invoke(email: String): ValidationResult {
        return if (email.isValidEmail()) {
            ValidationResult(
                successful = true,
            )
        } else {
            ValidationResult(
                successful = false,
                errorMessage = R.string.email_error
            )
        }
    }
}