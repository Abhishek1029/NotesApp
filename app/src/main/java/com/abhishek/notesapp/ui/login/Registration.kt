package com.abhishek.notesapp.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek.notesapp.R

@Composable
fun RegistrationComposable(
    modifier: Modifier = Modifier,
    onRegistrationClick: () -> Unit,
    onTextClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        HeadingComposable(
            R.string.create_new_account,
            MaterialTheme.colors.onSecondary
        )
        TextFieldComposable(
            R.string.name,
            R.string.enter_your_name,
            MaterialTheme.colors.onSecondary,
        )
        TextFieldComposable(
            R.string.email,
            R.string.enter_your_email,
            MaterialTheme.colors.onSecondary,
        )
        TextFieldComposable(
            R.string.password,
            R.string.enter_your_password,
            MaterialTheme.colors.onSecondary,
        )
        TextFieldComposable(
            R.string.confirm_password,
            R.string.re_enter_your_password,
            MaterialTheme.colors.onSecondary,
        )
        ButtonComposable(
            buttonText = R.string.proceed,
            onClick = onRegistrationClick
        )
        LoginSignUpComposable(
            text = R.string.already_have_an_account,
            clickableText = R.string.login_here,
            onTextClick = onTextClick
        )
    }
}

@Preview
@Composable
fun RegistrationPreview() {
    RegistrationComposable(
        onRegistrationClick = {},
        onTextClick = {}
    )
}