package com.abhishek.notesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek.notesapp.ui.login.LoginComposable
import com.abhishek.notesapp.ui.login.RegistrationComposable
import com.abhishek.notesapp.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
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
        }
    }
}

