package com.abhishek.notesapp

import com.abhishek.notesapp.utils.Utility
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun signupUser(
        name: String,
        email: String,
        password: String
    ): FirebaseUser?

    suspend fun loginUser(
        email: String,
        password: String
    ): FirebaseUser?
}

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun signupUser(
        name: String,
        email: String,
        password: String
    ): FirebaseUser? {
        var user: FirebaseUser? = null
        firebaseAuth.createUserWithEmailAndPassword(
            email, password
        ).addOnCompleteListener {
            user = if (it.isSuccessful) {
                it.result.user
            } else {
                null
            }
        }
        return user
    }

    override suspend fun loginUser(email: String, password: String): FirebaseUser? {
        var user: FirebaseUser? = null
        firebaseAuth.signInWithEmailAndPassword(
            email,
            password
        ).addOnCompleteListener {
            user = if (it.isSuccessful) {
                it.result.user
            } else {
                null
            }
        }
        return user
    }

}