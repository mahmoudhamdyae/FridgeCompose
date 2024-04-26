package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

import com.mahmoudhamdyae.fridgecompose.auth.domain.repository.Repository

class RegisterUseCase (
    private val repository: Repository,
) {

    suspend operator fun invoke(userName: String, email: String, password: String) {
        repository.register(userName, email, password)
    }
}