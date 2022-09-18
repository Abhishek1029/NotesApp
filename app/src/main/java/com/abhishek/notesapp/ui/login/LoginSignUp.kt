package com.abhishek.notesapp.ui.login

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek.notesapp.R

@Composable
fun LoginSignUpComposable(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @StringRes clickableText: Int,
    isClickable: Boolean = true,
    onTextClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(0.dp, 10.dp, 0.dp, 0.dp),
        horizontalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(id = text))
        Spacer(modifier = Modifier.size(5.dp))
        Text(
            text = stringResource(id = clickableText),
            Modifier.clickable(
                enabled = isClickable,
                onClick = onTextClick
            ),
            color = Color.Red
        )
    }
}

@Preview
@Composable
fun LoginSignUpPreview() {
    LoginSignUpComposable(
        text = R.string.do_not_have_an_account,
        clickableText = R.string.signup_here,
        onTextClick = {}
    )
}