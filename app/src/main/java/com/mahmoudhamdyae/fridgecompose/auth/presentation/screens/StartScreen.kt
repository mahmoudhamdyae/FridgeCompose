package com.mahmoudhamdyae.fridgecompose.auth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mahmoudhamdyae.fridgecompose.R
import com.mahmoudhamdyae.fridgecompose.core.composables.buttons.FilledButton
import com.mahmoudhamdyae.fridgecompose.core.composables.buttons.OutlinedButton
import com.mahmoudhamdyae.fridgecompose.core.ext.spacer
import com.mahmoudhamdyae.fridgecompose.core.navigation.NavigationDestination
import com.mahmoudhamdyae.fridgecompose.ui.theme.ColorRamps3
import com.mahmoudhamdyae.fridgecompose.ui.theme.White

object StartDestination: NavigationDestination {
    override val route: String = "start"
    override val titleRes: Int = R.string.start_screen_title
}

@Composable
fun StartScreen(
    openScreen: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = ColorRamps3,
        modifier = modifier.fillMaxHeight(),
    ) {
        StartScreenContent(openScreen = openScreen)
    }
}

@Composable
fun StartScreenContent(
    openScreen: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.spacer(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.start),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.startScreenHello),
            color = White,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = stringResource(id = R.string.startScreenHelloDesc),
            color = White,
            style = MaterialTheme.typography.labelSmall
        )
        
        FilledButton(
            color = White,
            text = R.string.startScreenLoginButton,
            onClick = { openScreen(LoginDestination.route) },
            modifier = Modifier.fillMaxWidth().padding(top = 32.dp, bottom = 16.dp)
        )
        OutlinedButton(
            color = White,
            text = R.string.startScreenRegisterButton,
            onClick = { openScreen(RegisterDestination.route) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}