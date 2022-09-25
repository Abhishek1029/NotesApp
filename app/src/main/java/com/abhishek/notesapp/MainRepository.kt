package com.abhishek.notesapp

import com.abhishek.notesapp.data.Note
import com.abhishek.notesapp.database.NoteDatabase
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val notesDatabase: NoteDatabase) {
    suspend fun saveNotes(note: Note) {
        notesDatabase
            .getNotesDao()
            .saveNotes(note)
    }

    suspend fun getNotes() = flow {
        emit(
            notesDatabase
                .getNotesDao()
                .getNotes()
        )
    }
}