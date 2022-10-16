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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhishek.notesapp.database.NoteDatabase
import com.abhishek.notesapp.ui.login.LauncherScreen
import com.abhishek.notesapp.ui.login.LoginComposable
import com.abhishek.notesapp.ui.login.RegistrationComposable
import com.abhishek.notesapp.ui.navigation.*
import com.abhishek.notesapp.ui.notes.AddNoteFABComposable
import com.abhishek.notesapp.ui.notes.AddNotes
import com.abhishek.notesapp.ui.notes.NotesListComposable
import com.abhishek.notesapp.ui.notes.NotesScreen
import com.abhishek.notesapp.ui.theme.NotesAppTheme
import com.abhishek.notesapp.utils.navigateWithSingleTop
import com.abhishek.notesapp.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                    var showLandingScreen by remember {
                        mutableStateOf(true)
                    }
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = if (showLandingScreen) LauncherDestination.route
                        else LoginDestination.route
                    ) {

                        composable(LauncherDestination.route) {
                            LauncherScreen(modifier = Modifier.fillMaxSize()) {
                                showLandingScreen = false
                            }
                        }

                        composable(LoginDestination.route) {
                            LoginComposable(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        color = Color.Blue
                                            .copy(alpha = 0.2f)
                                    ),
                                hiltViewModel(),
                                navController
                            ) {
                                navController.navigateWithSingleTop(SignupDestination.route)
                            }
                        }

                        composable(SignupDestination.route) {
                            RegistrationComposable(
                                viewModel = hiltViewModel(),
                                navController = navController
                            ) {
                                navController.navigateWithSingleTop(LoginDestination.route)
                            }
                        }

                        composable(NotesListDestination.route) {
                            NotesListComposable(navController = navController)
                        }

                        composable(AddNotesDestination.route) {
                            AddNotes(onButtonClick = { }) {

                            }
                        }
                    }
                }
            }
        }
    }
}

