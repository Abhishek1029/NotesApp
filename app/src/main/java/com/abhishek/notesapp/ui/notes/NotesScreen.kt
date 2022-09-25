package com.abhishek.notesapp.ui.notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.abhishek.notesapp.MainViewModel
import com.abhishek.notesapp.data.Note

@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = viewModel()
) {
    val notesList: List<Note>? by mainViewModel.notesSF.collectAsState()
    if (notesList.isNullOrEmpty()) {
        notesList?.let {
            NotesListComposable(notesList = it)
        }
    } else {
        notesList?.let {
            NotesListComposable(notesList = it)
        }
    }
}