package com.abhishek.notesapp.utils

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(
    message: String,
    toastLength: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(this, message, toastLength).show()
}