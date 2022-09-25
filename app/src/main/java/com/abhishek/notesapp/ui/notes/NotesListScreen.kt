package com.abhishek.notesapp.ui.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek.notesapp.R
import com.abhishek.notesapp.data.Note

@Composable
fun NotesListComposable(
    modifier: Modifier = Modifier,
    notesList: List<Note>
) {
    Scaffold(modifier = modifier,
        floatingActionButton = {
            AddNoteFABComposable()
        }
    ) {
        LazyColumn(modifier) {
            items(notesList) { note ->
                NoteComposable(note = note)
            }
        }
    }
}

@Composable
fun AddNoteFABComposable(
    modifier: Modifier = Modifier
) {
    FloatingActionButton(
        onClick = { },
        backgroundColor = Color.Magenta
    ) {
        Icon(
            painter =
            painterResource(id = R.drawable.ic_baseline_add_24),
            contentDescription = "Add Note"
        )
    }
}

@Composable
fun NoteComposable(
    modifier: Modifier = Modifier,
    note: Note
) {
    Column(modifier) {
        Text(text = note.text)
        Text(text = note.description)
    }
}

@Preview
@Composable
fun AddNoteFABPreview() {
    AddNoteFABComposable()
}

@Preview
@Composable
fun NotesListPreview() {
    NotesListComposable(notesList = emptyList())
}
