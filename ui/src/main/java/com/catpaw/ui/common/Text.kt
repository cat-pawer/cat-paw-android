package com.catpaw.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SubTitleText(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun ContentText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    fontWeight: FontWeight? = null
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = fontWeight,
        color = color,
    )
}

@Composable
fun SmallContentText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = 14.sp,
    )
}

@Composable
fun SmallContentGrayText(
    text: String,
    modifier: Modifier = Modifier,
) {
    SmallContentText(
        text = text,
        modifier = modifier,
        color = Color.Gray,
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    Column {
        TitleText(text = "Title")
        SubTitleText(text = "Sub Title")
        ContentText(text = "Content")
        SmallContentText(text = "Small Content")
    }
}