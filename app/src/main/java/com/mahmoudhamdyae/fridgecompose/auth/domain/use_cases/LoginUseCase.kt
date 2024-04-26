package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

import com.mahmoudhamdyae.fridgecompose.auth.domain.repository.Repository

class LoginUseCase (
    private val repository: Repository
) {

    suspend operator fun invoke(email: String, password: String) {
        repository.login(email, password)
    }
}