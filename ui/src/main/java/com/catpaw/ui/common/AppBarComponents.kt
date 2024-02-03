package com.catpaw.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.NavigateBefore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavButtonDefault(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.AutoMirrored.Rounded.NavigateBefore, contentDescription = "뒤로 가기")
    }
}

@Composable
fun AppBarText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(text = text, modifier = modifier)
}