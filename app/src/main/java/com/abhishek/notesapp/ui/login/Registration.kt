package com.abhishek.notesapp.ui.login

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.abhishek.notesapp.AuthViewModel
import com.abhishek.notesapp.MainViewModel
import com.abhishek.notesapp.R
import com.abhishek.notesapp.data.User
import com.abhishek.notesapp.ui.navigation.NotesListDestination
import com.abhishek.notesapp.utils.Helper
import com.abhishek.notesapp.utils.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun RegistrationComposable(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel,
    navController: NavHostController?,
    onTextClick: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val signupResult = viewModel.signupFlow.collectAsState()
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
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
        ) {
            name = it
        }
        TextFieldComposable(
            R.string.email,
            R.string.enter_your_email,
            MaterialTheme.colors.onSecondary,
        ) {
            email = it
        }
        TextFieldComposable(
            R.string.password,
            R.string.enter_your_password,
            MaterialTheme.colors.onSecondary,
        ) {
            password = it
        }
        TextFieldComposable(
            R.string.confirm_password,
            R.string.re_enter_your_password,
            MaterialTheme.colors.onSecondary,
        ) {
            confirmPassword = it
        }
        ButtonComposable(
            buttonText = R.string.proceed,
        ) {
            coroutineScope.launch(Dispatchers.IO) {
                val pair = Helper.isDataValid(name, email, password, confirmPassword)
                if (pair.first) {
                    viewModel.signupUser(name, email, password)
                } else {
                    withContext(Dispatchers.Main) {
                        context.showToast(pair.second)
                    }
                }
            }
        }
        LoginSignUpComposable(
            text = R.string.already_have_an_account,
            clickableText = R.string.login_here,
            onTextClick = onTextClick
        )
    }

    if (signupResult.value != null) {
        navController?.navigate(NotesListDestination.route)
    }
}

@Preview
@Composable
fun RegistrationPreview() {
    RegistrationComposable(
        viewModel = viewModel(),
        navController = null,
        onTextClick = {}
    )
}