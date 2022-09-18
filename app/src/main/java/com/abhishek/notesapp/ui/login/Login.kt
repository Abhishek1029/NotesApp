package com.abhishek.notesapp.ui.login

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek.notesapp.NotesApp
import com.abhishek.notesapp.R


@Composable
fun LoginComposable(
    modifier: Modifier = Modifier,
    context: Context?
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        HeadingComposable(
            R.string.login_into_your_account,
            MaterialTheme.colors.onSecondary
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
        ButtonComposable(buttonText = R.string.proceed,
            onLoginClick = {
                Toast.makeText(
                    context,
                    "Login CLicked", Toast.LENGTH_SHORT
                ).show()
            })
    }
}

@Composable
fun TextFieldComposable(
    @StringRes labelText: Int,
    @StringRes hint: Int,
    textColor: Color
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 0.dp)
    ) {
        Text(
            text = stringResource(id = labelText),
            color = textColor,
            style = MaterialTheme.typography.h6,
        )
        TextField(
            value = stringResource(id = hint),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun HeadingComposable(
    @StringRes headingText: Int,
    textColor: Color
) {
    Text(
        text = stringResource(id = headingText),
        color = textColor,
        style = MaterialTheme.typography.h5,
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun ButtonComposable(
    modifier: Modifier = Modifier,
    @StringRes buttonText: Int,
    onLoginClick: () -> Unit
) {
    Button(
        onClick = onLoginClick,
        modifier = modifier
            .width(130.dp)
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) {
        Text(text = stringResource(id = buttonText))
    }
}

@Preview
@Composable
fun HeadingComposablePreview() {
    HeadingComposable(
        R.string.login_into_your_account,
        MaterialTheme.colors.onPrimary
    )
}

@Preview
@Composable
fun TextFieldComposablePreview() {
    TextFieldComposable(
        R.string.email,
        R.string.enter_your_email,
        MaterialTheme.colors.onSecondary,
    )
}

@Preview
@Composable
fun ButtonComposablePreview() {
    ButtonComposable(buttonText = R.string.proceed, onLoginClick = {})
}

@Preview
@Composable
fun LoginComposablePreview() {
    LoginComposable(context = null)
}