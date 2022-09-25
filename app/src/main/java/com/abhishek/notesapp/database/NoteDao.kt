package com.abhishek.notesapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.abhishek.notesapp.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    suspend fun saveNotes(note: Note)

    @Query("SELECT * FROM notes")
    suspend fun getNotes(): List<Note>
}