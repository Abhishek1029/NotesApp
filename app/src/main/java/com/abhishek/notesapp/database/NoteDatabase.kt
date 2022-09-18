package com.abhishek.notesapp.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.abhishek.notesapp.NotesApp
import com.abhishek.notesapp.data.Note
import com.abhishek.notesapp.utils.Constants

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNotesDao(): NoteDao

    companion object {
        var INSTANCE: NoteDatabase? = null
        fun getDatabase(context: Context): NoteDatabase? {
            if (INSTANCE == null)
                INSTANCE = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    Constants.ROOM_DATABASE_NAME
                ).build()
            return INSTANCE
        }
    }
}