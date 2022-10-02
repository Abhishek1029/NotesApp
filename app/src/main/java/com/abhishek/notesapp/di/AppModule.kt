package com.abhishek.notesapp.di

import android.app.Application
import androidx.room.Room
import com.abhishek.notesapp.AuthRepository
import com.abhishek.notesapp.AuthRepositoryImpl
import com.abhishek.notesapp.database.NoteDatabase
import com.abhishek.notesapp.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): NoteDatabase = Room.databaseBuilder(
        application.applicationContext,
        NoteDatabase::class.java,
        Constants.ROOM_DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun providesFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository =
        AuthRepositoryImpl(firebaseAuth)
}