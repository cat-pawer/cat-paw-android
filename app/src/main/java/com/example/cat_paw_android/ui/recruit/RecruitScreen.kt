package com.example.cat_paw_android.ui.recruit

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cat_paw_android.model.Project
import com.example.cat_paw_android.ui.common.SkillChip


@Composable
fun ProjectsColumn(projects: List<Project>) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
//        modifier = Modifier.background(Color.Green),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(projects) { project ->
            ProjectCard(project = project)
        }
    }
}

@Composable
fun ProjectsRow(projects: List<Project>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(projects) { project ->
            ProjectCard(project = project)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectsRowPreview() {
    ProjectsRow(exampleProjectList)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectCard(project: Project) {
    ElevatedCard(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .size(width = 330.dp, height = 200.dp)
            .border(1.dp, shape = MaterialTheme.shapes.medium, color = Color.White)
            .shadow(8.dp),
        onClick = {}) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row {
                for (tag in project.tags) {
                    Text(
                        text = "#$tag ", color = Color(0xFFC5C5C5)
                    )
                }
            }
            Text(
                text = project.title,
                minLines = 2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                for (skill in project.skills.take(3)) {
                    SkillChip(skill = skill)
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .border(1.dp, color = Color(0xFFC5C5C5))
                    .padding(5.dp)
            )
            Row(
//                verticalArrangement =Arrangement.
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("날짜")
                Spacer(modifier = Modifier.weight(1f))
                Text(project.replyCount.toString() + "  ", color = Color(0xFFC5C5C5))
                Text(project.viewCount.toString(), color = Color(0xFFC5C5C5))
            }

        }
    }
}

private val exampleProjectList = listOf(
    Project(
        title = "et51n2nnnt2nt2".repeat(5),
        tags = listOf("백", "프론트"),
        replyCount = 9293,
        viewCount = 3867,
        skills = listOf("Java", "TS")
    ), Project(
        title = "etanewtntewa".repeat(10),
        tags = listOf("백", "프론트"),
        replyCount = 9293,
        viewCount = 3867,
        skills = listOf("Java", "TS")
    ), Project(
        title = "et",
        tags = listOf("백", "프론트"),
        replyCount = 9293,
        viewCount = 3867,
        skills = listOf("Java", "TS")
    ), Project(
        title = "pulvinar",
        tags = listOf("디자이너"),
        replyCount = 1442,
        viewCount = 8213,
        skills = listOf("Figma", "디자인툴")
    ), Project(
        title = "pulvinar",
        tags = listOf("디자이너"),
        replyCount = 1442,
        viewCount = 8213,
        skills = listOf("Figma", "디자인툴")
    ), Project(
        title = "pulvinar",
        tags = listOf("디자이너"),
        replyCount = 1442,
        viewCount = 8213,
        skills = listOf("Figma", "디자인툴")
    ), Project(
        title = "pulvinar",
        tags = listOf("디자이너"),
        replyCount = 1442,
        viewCount = 8213,
        skills = listOf("Figma", "디자인툴")
    )
)