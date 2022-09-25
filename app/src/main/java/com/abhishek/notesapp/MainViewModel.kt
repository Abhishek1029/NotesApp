package com.abhishek.notesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.notesapp.data.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    private val _notesMSF = MutableStateFlow<List<Note>>(emptyList())
    val notesSF: StateFlow<List<Note>>
        get() = _notesMSF

    fun saveNotes(note: Note) {
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
}