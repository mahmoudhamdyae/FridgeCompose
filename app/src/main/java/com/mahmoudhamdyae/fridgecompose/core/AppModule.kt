package com.mahmoudhamdyae.fridgecompose.core

import com.mahmoudhamdyae.fridgecompose.auth.data.remote.RemoteDataSource
import com.mahmoudhamdyae.fridgecompose.auth.data.remote.RemoteDataSourceImpl
import com.mahmoudhamdyae.fridgecompose.auth.data.repository.RepositoryImpl
import com.mahmoudhamdyae.fridgecompose.auth.domain.repository.Repository
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.LoginUseCase
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.RegisterUseCase
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.SignOutUseCase
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidateEmail
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidatePassword
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidateRepeatedPassword
import com.mahmoudhamdyae.fridgecompose.auth.domain.use_cases.ValidateUserName
import com.mahmoudhamdyae.fridgecompose.auth.presentation.view_model.LoginViewModel
import com.mahmoudhamdyae.fridgecompose.auth.presentation.view_model.RegisterViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl(get()) }
    single<HttpClient> { HttpClient(CIO) }
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<LoginUseCase> { LoginUseCase(get()) }
    single<RegisterUseCase> { RegisterUseCase(get()) }
    single<SignOutUseCase> { SignOutUseCase(get()) }
    single<ValidateEmail> { ValidateEmail() }
    single<ValidatePassword> { ValidatePassword() }
    single<ValidateRepeatedPassword> { ValidateRepeatedPassword() }
    single<ValidateUserName> { ValidateUserName() }
    single<BaseUseCase> { BaseUseCase(get(), get(), get(), get(), get(), get(), get()) }
    viewModelOf(::LoginViewModel)
    viewModelOf(::RegisterViewModel)
}