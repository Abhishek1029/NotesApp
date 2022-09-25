package com.abhishek.notesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.abhishek.notesapp.database.NoteDatabase
import com.abhishek.notesapp.ui.login.LauncherScreen
import com.abhishek.notesapp.ui.login.LoginComposable
import com.abhishek.notesapp.ui.login.RegistrationComposable
import com.abhishek.notesapp.ui.theme.NotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var notesDatabase: NoteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var showLandingScreen by remember {
                        mutableStateOf(true)
                    }
                    if (showLandingScreen) {
                        LauncherScreen(onTimeout = {showLandingScreen = false})
                    } else {
                        LaunchLoginOrRegistrationScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun LaunchLoginOrRegistrationScreen() {
        var isLoginScreen by remember {
            mutableStateOf(true)
        }
        if (isLoginScreen) {
            LoginComposable(
                modifier = Modifier
                    .background(
                        color = Color.Blue
                            .copy(alpha = 0.2f)
                    ),
                onLoginClick = {
                    Toast.makeText(
                        this,
                        "Login CLicked", Toast.LENGTH_SHORT
                    ).show()
                },
                onTextClick = {
                    isLoginScreen = false
                }
            )
        } else {
            RegistrationComposable(
                modifier = Modifier
                    .background(
                        color = Color.Blue
                            .copy(alpha = 0.2f)
                    ),
                onRegistrationClick = {
                    Toast.makeText(
                        this,
                        "RegistrationClicked CLicked", Toast.LENGTH_SHORT
                    ).show()
                },
                onTextClick = {
                    isLoginScreen = true
                }
            )
        }
    }
}

