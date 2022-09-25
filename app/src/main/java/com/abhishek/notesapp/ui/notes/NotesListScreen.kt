package com.abhishek.notesapp.ui.notes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        LazyColumn(modifier.fillMaxWidth()) {
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
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = MaterialTheme.shapes.medium.copy(CornerSize(5.dp)),
        elevation = 4.dp
    ) {
        Column(modifier) {
            Text(
                text = note.text,
                Modifier.padding(start = 5.dp, end = 5.dp)
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = note.description,
                Modifier.padding(start = 5.dp, end = 5.dp)
            )
        }
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
