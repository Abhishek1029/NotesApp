package com.abhishek.notesapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "AuthViewModel"

@HiltViewModel
class AuthViewModel @Inject constructor(
    private var authRepository: AuthRepository
) : ViewModel() {

    private val _signupFlow: MutableStateFlow<FirebaseUser?> = MutableStateFlow(null)
    val signupFlow: StateFlow<FirebaseUser?>
        get() = _signupFlow

    private val _loginFlow: MutableStateFlow<FirebaseUser?> = MutableStateFlow(null)
    val loginFlow: StateFlow<FirebaseUser?>
        get() = _loginFlow

    suspend fun signupUser(
        name: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val user = authRepository.signupUser(name, email, password)
            Log.e(TAG, "signupUser: $user")
            _signupFlow.value = user
        }
    }

    suspend fun loginUser(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val user = authRepository.loginUser(email, password)
            _loginFlow.value = user
        }
    }
}