package com.abhishek.notesapp.utils

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.abhishek.notesapp.utils.Constants.NOTES_DATA_STORE

class NotesPreferenceStore {
    private val Context.dataStore by preferencesDataStore(NOTES_DATA_STORE)
}