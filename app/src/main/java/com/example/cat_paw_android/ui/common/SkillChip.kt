package com.example.cat_paw_android.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SkillChip(skill: String) {
    AssistChip(
        leadingIcon = { Icon(Icons.Default.Info, contentDescription = "스킬 아이콘") },
        onClick = { /* 클릭 불가 */ },
        label = { Text(skill, maxLines = 1) },
        shape = CircleShape,
        border = AssistChipDefaults.assistChipBorder(
            borderColor = MaterialTheme.colorScheme.primary,
            borderWidth = 1.dp,
        ),
        modifier = Modifier.padding(end = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SkillChipPreview() {
    SkillChip(skill = "Java")
}