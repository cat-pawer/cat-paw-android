package com.catpaw.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.catpaw.recruit.model.RecruitType

@Composable
fun RecruitTypeChip(recruitType: RecruitType) {
    AssistChip(
        leadingIcon = { Icon(Icons.Outlined.Info, contentDescription = "프로젝트 종류 아이콘", tint= Color.Black) },
        onClick = { /* 클릭 불가 */ },
        label = { Text(recruitType.korean, maxLines = 1) },
        shape = CircleShape,
        border = AssistChipDefaults.assistChipBorder(
            borderColor = Color.Transparent,
            borderWidth = 1.dp,
        ),
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            labelColor = Color.White
        ),
        modifier = Modifier.padding(end = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun RecruitTypeChipPreview() {
    RecruitTypeChip(recruitType = RecruitType.PROJECT)
}