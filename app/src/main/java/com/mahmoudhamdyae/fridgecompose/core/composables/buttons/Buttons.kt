package com.mahmoudhamdyae.fridgecompose.core.composables.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mahmoudhamdyae.fridgecompose.ui.theme.Black
import com.mahmoudhamdyae.fridgecompose.ui.theme.White

@Composable
fun FilledButton(
    color: Color,
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(32),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = Black,
        )
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Composable
fun OutlinedButton(
    color: Color,
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    androidx.compose.material3.OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        border = BorderStroke(1.dp, color),
        shape = RoundedCornerShape(32),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = White,
        )
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Composable
fun BorderlessButton(
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        )
    ) {
        Text(
            text = stringResource(id = text),
            color = White,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}