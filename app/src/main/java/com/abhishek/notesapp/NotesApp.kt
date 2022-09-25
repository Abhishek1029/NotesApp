package com.abhishek.notesapp

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotesApp : Application() {
    private lateinit var context: Context
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    fun getContext(): Context {
        return context
    }
}