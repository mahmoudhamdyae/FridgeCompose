package com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases

import com.mahmoudhamdyae.fridgecompose.auth.domain.repository.Repository

class SignOutUseCase (
    private val repository: Repository
) {

    suspend operator fun invoke() {
        repository.signOut()
    }
}