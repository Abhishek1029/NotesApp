package com.abhishek.notesapp.utils

import androidx.navigation.NavHostController

fun NavHostController.navigateWithSingleTop(route: String) {
    this.navigate(route){
        launchSingleTop = true
    }
}