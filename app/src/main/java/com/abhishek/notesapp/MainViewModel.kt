package com.abhishek.notesapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.notesapp.data.Note
import com.abhishek.notesapp.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    private val _notesMSF = MutableStateFlow<List<Note>>(emptyList())
    val notesSF: StateFlow<List<Note>>
        get() = _notesMSF

    init {
        getNotes()
    }

    fun saveNotes(note: Note) {
        Log.e("saveNotes: ", note.text)
        viewModelScope.launch {
            repository.saveNotes(note)
        }
    }

    fun getNotes() {
        viewModelScope.launch {
            repository.getNotes().collect {
                _notesMSF.value = it
            }
        }
    }

    suspend fun insertUser(
        user: User
    ) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}