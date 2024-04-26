package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

import com.mahmoudhamdyae.fridgecompose.R
import com.mahmoudhamdyae.fridgecompose.core.ext.passwordMatches

class ValidateRepeatedPassword {

    operator fun invoke(password: String, repeatedPassword: String): ValidationResult {
        return if (password.passwordMatches(repeatedPassword)) {
            ValidationResult(
                successful = true,
            )
        } else {
            ValidationResult(
                successful = false,
                errorMessage = R.string.password_match_error
            )
        }
    }
}