package com.abhishek.notesapp.utils

import com.google.firebase.auth.FirebaseUser

sealed class Utility<Any> {
    object LOADING : Utility<Any>()
    class SUCCESS(val firebaseUser: FirebaseUser?) : Utility<Any>()
    class FAILURE(val message: String) : Utility<Any>()
}
