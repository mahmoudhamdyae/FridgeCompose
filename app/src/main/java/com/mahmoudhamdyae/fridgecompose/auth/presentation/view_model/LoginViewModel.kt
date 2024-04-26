package com.mahmoudhamdyae.fridgecompose.auth.presentation.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudhamdyae.fridgecompose.auth.presentation.AuthFormEvent
import com.mahmoudhamdyae.fridgecompose.auth.presentation.AuthFormState
import com.mahmoudhamdyae.fridgecompose.auth.presentation.ValidationEvent
import com.mahmoudhamdyae.fridgecompose.core.BaseUseCase
import com.mahmoudhamdyae.fridgecompose.home.presentation.screens.HomeDestination
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val useCase: BaseUseCase
): ViewModel() {

    var state by mutableStateOf(AuthFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: AuthFormEvent) {
        when (event) {
            is AuthFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is AuthFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is AuthFormEvent.Submit -> {
                submitData()
            }
            else -> {
                throw Exception("Unknown event")
            }
        }
    }

    private fun submitData() {
        val emailResult = useCase.validateEmail(state.email)
        val passwordResult = useCase.validatePassword(state.password, true)

        val hasError = listOf(
            emailResult,
            passwordResult
        ).any { !it.successful }

        if (hasError) {
            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    fun onSignInClick(navigate: (String) -> Unit) {
        viewModelScope.launch {
            useCase.loginUseCase(state.email, state.password)
            navigate(HomeDestination.route)
        }
    }
}