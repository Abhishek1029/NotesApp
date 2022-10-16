package com.abhishek.notesapp.utils

import androidx.datastore.preferences.core.booleanPreferencesKey

object PreferenceKeys {
   val IS_USER_LOGGED_IN = booleanPreferencesKey("is_user_logged_in")
}