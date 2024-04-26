package com.mahmoudhamdyae.fridgecompose.auth.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahmoudhamdyae.fridgecompose.auth.presentation.AuthFormEvent
import com.mahmoudhamdyae.fridgecompose.auth.presentation.AuthFormState
import com.mahmoudhamdyae.fridgecompose.auth.presentation.ValidationEvent
import com.mahmoudhamdyae.fridgecompose.auth.presentation.view_model.LoginViewModel
import com.mahmoudhamdyae.fridgecompose.R
import com.mahmoudhamdyae.fridgecompose.core.composables.BasicButton
import com.mahmoudhamdyae.fridgecompose.core.composables.BasicTextButton
import com.mahmoudhamdyae.fridgecompose.core.composables.BasicToolBar
import com.mahmoudhamdyae.fridgecompose.core.composables.EmailField
import com.mahmoudhamdyae.fridgecompose.core.composables.PasswordField
import com.mahmoudhamdyae.fridgecompose.core.ext.basicButton
import com.mahmoudhamdyae.fridgecompose.core.ext.fieldModifier
import com.mahmoudhamdyae.fridgecompose.core.ext.textButton
import com.mahmoudhamdyae.fridgecompose.core.navigation.NavigationDestination
import org.koin.androidx.compose.getViewModel

object LoginDestination: NavigationDestination {
    override val route: String = "login"
    override val titleRes: Int = R.string.app_name
}

@Composable
fun LoginScreen(
    openAndClear: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = getViewModel()
) {
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is ValidationEvent.Success -> {
                    viewModel.onSignInClick(openAndClear)
                }
            }
        }
    }

    LogInScreenContent(
        openAndPopUp = openAndClear,
        state = state,
        onEvent = viewModel::onEvent,
        modifier = modifier,
    )
}

@Composable
private fun LogInScreenContent(
    openAndPopUp: (String) -> Unit,
    state: AuthFormState,
    onEvent: (AuthFormEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val fieldModifier = Modifier.fieldModifier()
    val focusManager = LocalFocusManager.current

    BasicToolBar(title = LoginDestination.titleRes)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = R.string.log_in_screen_title),
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp),
            modifier = Modifier.padding(start = 16.dp)
        )
        Row(modifier = Modifier.textButton(), verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(id = R.string.new_in_app))
            BasicTextButton(text = R.string.sig_up_for_free) {
                openAndPopUp(RegisterDestination.route)
            }
        }
        EmailField(
            value = state.email,
            onNewValue = { onEvent(AuthFormEvent.EmailChanged(it)) },
            emailError = state.emailError,
            focusManager = focusManager,
            modifier = fieldModifier
        )
        PasswordField(
            value = state.password,
            onNewValue = { onEvent(AuthFormEvent.PasswordChanged(it)) },
            passwordError = state.passwordError,
            focusManager = focusManager,
            modifier = fieldModifier
        )

        BasicButton(R.string.log_in_button, Modifier.basicButton()) {
            onEvent(AuthFormEvent.Submit)
        }
    }
}