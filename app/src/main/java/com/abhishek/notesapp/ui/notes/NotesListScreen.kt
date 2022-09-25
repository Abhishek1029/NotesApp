package com.abhishek.notesapp.ui.notes

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.abhishek.notesapp.R

@Composable
fun NotesListComposable(
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier,
        floatingActionButton = {
            AddNoteFABComposable()
        }
    ) {
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

@Preview
@Composable
fun AddNoteFABPreview() {
    AddNoteFABComposable()
}

@Preview
@Composable
fun NotesListPreview() {
    NotesListComposable()
}