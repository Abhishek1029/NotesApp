package com.abhishek.notesapp.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek.notesapp.R
import kotlinx.coroutines.delay

const val SplashTimeOut: Long = 2000

@Composable
fun LauncherScreen(
    modifier: Modifier = Modifier,
    onTimeout: () -> Unit
) {
    LaunchedEffect(true) {
        delay(SplashTimeOut)
        onTimeout()
    }
    Image(
        painter = painterResource(id = R.drawable.notes_icon),
        contentDescription = stringResource(id = R.string.launcher_icon),
        modifier = modifier.size(200.dp),
        alignment = Alignment.Center
    )
}

@Preview
@Composable
fun LauncherScreenPreview() {
    LauncherScreen(onTimeout = {})
}