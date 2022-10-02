package com.abhishek.notesapp.utils

import android.content.Context
import java.util.regex.Pattern

object Helper {
    fun isDataValid(
        name: String?,
        email: String?,
        password: String?,
        confirmPassword: String?
    ): Pair<Boolean, String> {
        var pair = Pair(true, "Data is Valid")
        if (name.isNullOrBlank()) {
            pair = Pair(false, "Name can't be blank")
        } else if (email.isNullOrBlank()) {
            pair = Pair(false, "Email can't be blank")
        } else if (!Pattern.matches(Constants.EMAIL_PATTERN, email)) {
            pair = Pair(false, "Please enter valid email address")
        } else if (password.isNullOrBlank()) {
            pair = Pair(false, "Password can't be blank")
        } else if (!password.equals(confirmPassword, false)) {
            pair = Pair(false, "Password and Confirm Password Must Match")
        }
        return pair
    }
}