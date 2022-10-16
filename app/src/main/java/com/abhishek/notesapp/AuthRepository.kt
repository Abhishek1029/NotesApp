package com.abhishek.notesapp

import android.util.Log
import com.abhishek.notesapp.utils.Utility
import com.abhishek.notesapp.utils.await
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.math.log

private const val TAG = "AuthRepository"

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
        val user = firebaseAuth.createUserWithEmailAndPassword(
            email, password
        ).await()
        user?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())
            ?.await()
        return user?.user
    }

    override suspend fun loginUser(email: String, password: String): FirebaseUser? {
        val user = firebaseAuth.signInWithEmailAndPassword(
            email,
            password
        ).await()
        return user?.user
    }

}