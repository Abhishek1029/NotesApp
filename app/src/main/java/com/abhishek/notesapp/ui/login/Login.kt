package com.abhishek.notesapp.ui.login

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.abhishek.notesapp.AuthViewModel
import com.abhishek.notesapp.R
import com.abhishek.notesapp.ui.navigation.NotesListDestination
import com.abhishek.notesapp.ui.notes.NotesActivity
import com.abhishek.notesapp.utils.Helper
import com.abhishek.notesapp.utils.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "Login"
@Composable
fun LoginComposable(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel,
    navController: NavController?,
    onTextClick: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val loginResult = viewModel.loginFlow.collectAsState()
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
            textColor = MaterialTheme.colors.onSecondary,
        ) {
            email = it
        }
        TextFieldComposable(
            R.string.password,
            R.string.enter_your_password,
            textColor = MaterialTheme.colors.onSecondary,
        ) {
            password = it
        }
        ButtonComposable(
            buttonText = R.string.proceed,
        ) {
           // navController?.navigate(NotesListDestination.route)
            coroutineScope.launch(Dispatchers.IO) {
                viewModel.loginUser(email, password)
            }
        }
        LoginSignUpComposable(
            text = R.string.do_not_have_an_account,
            clickableText = R.string.signup_here,
            onTextClick = onTextClick
        )
    }
    if (loginResult.value != null) {
        //context.showToast("Successfully LoggedIn")
        Log.e(TAG, "LoginComposable: ${loginResult.value}" )
        LaunchedEffect(true){
            context.startActivity(Intent(context,NotesActivity::class.java))
            (context as Activity).finish()
        }
    }
}

@Composable
fun TextFieldComposable(
    @StringRes labelText: Int,
    @StringRes hint: Int,
    textColor: Color,
    onTextChanged: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 0.dp)
    ) {
        var text by remember {
            mutableStateOf("")
        }
        Text(
            text = stringResource(id = labelText),
            color = textColor,
            style = MaterialTheme.typography.h6,
        )
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                onTextChanged(newText)
            },
            label = {
                Text(text = stringResource(id = hint))
            },
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
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
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
        textColor = MaterialTheme.colors.onSecondary,
        onTextChanged = {}
    )
}

@Preview
@Composable
fun ButtonComposablePreview() {
    ButtonComposable(buttonText = R.string.proceed, onClick = {})
}


@Preview
@Composable
fun LoginComposablePreview() {
    LoginComposable(
        viewModel = hiltViewModel(),
        navController = null,
        onTextClick = {}
    )
}