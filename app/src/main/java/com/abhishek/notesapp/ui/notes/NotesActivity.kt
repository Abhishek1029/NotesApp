package com.abhishek.notesapp.ui.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abhishek.notesapp.ui.navigation.AddNotesDestination
import com.abhishek.notesapp.ui.navigation.NotesDestination
import com.abhishek.notesapp.ui.navigation.NotesListDestination
import com.abhishek.notesapp.ui.theme.NotesAppTheme

class NotesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NotesListDestination.route
                    ) {
                        composable(AddNotesDestination.route) {
                            AddNotes(onButtonClick = { /*TODO*/ }, onTextChange = {})
                        }
                    }
                }
            }
        }
    }
}
