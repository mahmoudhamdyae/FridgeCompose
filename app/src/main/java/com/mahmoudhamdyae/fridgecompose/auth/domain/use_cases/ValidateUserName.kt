package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

import com.mahmoudhamdyae.fridgecompose.R
import com.mahmoudhamdyae.fridgecompose.core.ext.isValidUserName

class ValidateUserName {

    operator fun invoke(userName: String): ValidationResult {
        return if (userName.isValidUserName()) {
            ValidationResult(
                successful = true,
            )
        } else {
            ValidationResult(
                successful = false,
                errorMessage = R.string.user_name_error
            )
        }
    }
}