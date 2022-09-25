package com.abhishek.notesapp.ui.notes

import androidx.compose.runtime.*
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
    var noteText by remember {
        mutableStateOf("")
    }
    if (notesList.isNullOrEmpty()) {
        AddNotes(
            onButtonClick = {
                mainViewModel.saveNotes(Note(text = noteText, description = noteText))
            },
            onTextChange = {
                noteText = it
            }
        )
    } else {
        notesList?.let {
            NotesListComposable(notesList = it)
        }
    }
}