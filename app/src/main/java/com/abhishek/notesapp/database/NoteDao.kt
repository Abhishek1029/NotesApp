package com.abhishek.notesapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.abhishek.notesapp.data.Note

@Dao
interface NoteDao {
    @Insert
    fun saveNotes(note: Note)

    @Query("SELECT * FROM notes")
    fun getNotes(): List<Note>
}