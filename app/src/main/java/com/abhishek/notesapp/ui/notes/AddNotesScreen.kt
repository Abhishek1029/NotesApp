package com.abhishek.notesapp.ui.notes

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek.notesapp.R

@Composable
fun AddNotes(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    onTextChange: (String) -> Unit
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    var description by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
    ) {
        Spacer(modifier = Modifier.size(20.dp))

        OutlinedTextField(
            value = text, onValueChange = {
                text = it
                onTextChange(it)
            })
        Spacer(modifier = Modifier.size(10.dp))

        OutlinedTextField(value = description, onValueChange = {
            description = it
            onTextChange(it)
        })

        Spacer(modifier = Modifier.size(10.dp))

        OutlinedButton(onClick = onButtonClick) {
            Text(text = stringResource(id = R.string.add_note))
        }
    }
}

@Preview
@Composable
fun AddNotesPreview() {

}