package com.catpaw.ui.recruit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.catpaw.recruit.model.Project
import com.catpaw.ui.common.SkillChip
import com.catpaw.ui.theme.CatpawandroidTheme
import com.catpaw.ui.theme.Seagull

@Preview(showBackground = true, device = "id:pixel_7_pro")
@Composable
fun RecruitScreenPreview() {
    CatpawandroidTheme {
        Surface(Modifier.fillMaxWidth()) {
            RecruitScreen(Modifier.padding(horizontal = 16.dp))
        }
    }
}


@Composable
fun SpacerMedium() {
    Spacer(modifier = Modifier.size(16.dp))
}

@Composable
fun SpacerLow() {
    Spacer(modifier = Modifier.size(8.dp))
}

@Composable
fun RecruitScreen(
    modifier: Modifier = Modifier,
    recruitViewModel: RecruitViewModel = viewModel()
) {
    val recruitUiState by recruitViewModel.uiState.collectAsState()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        item {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Info,
                    modifier = Modifier
                        .padding(top = 16.dp, end = 16.dp)
                        .scale(2f),
                    contentDescription = null,
                )
            }
            SpacerMedium()
            RecruitTitle(modifier)
            SearchField(
                modifier = modifier,
                value = recruitUiState.searchKeyword,
                onValueChange = { recruitViewModel.changeSearchKeyword(it) },
            )
            SpacerLow()
            ProjectsRow(
                title = "신상 프로젝트",
                projects = exampleProjectList,
                modifier = modifier.padding(vertical = 4.dp),
            )
            SpacerMedium()
            ProjectsRow(
                title = "마감임박 프로젝트",
                projects = exampleProjectList,
                backgroundColor = Seagull,
                modifier = modifier.padding(vertical = 4.dp),
            )
            SpacerMedium()
        }
        items(exampleProjectList) {
            ProjectCard(project = it)
        }
    }
}

@Composable
fun RecruitTitle(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = "프로젝트를 만나볼 준비 되었나요?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "원하는 프로젝트는 다 만날 수 있어요!",
        )
    }
}

@Composable
fun SearchField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "검색어") },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Default
        ),
        keyboardActions = KeyboardActions(
            onDone = { }
        )
    )
}

@Composable
fun ProjectsColumn(
    projects: List<Project>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        items(projects) { project ->
            ProjectCard(project = project)
        }
    }
}

@Composable
fun ProjectsRow(
    title: String,
    projects: List<Project>,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
) {
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .padding(top = 8.dp, bottom = 16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = modifier,
        )
//        SpacerLow()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(projects) { project ->
                ProjectCard(project = project)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectsRowPreview() {
    ProjectsRow("title", exampleProjectList)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectCard(project: Project) {
    ElevatedCard(modifier = Modifier
        .padding(vertical = 4.dp)
        .size(width = 280.dp, height = 180.dp)
        .border(1.dp, shape = MaterialTheme.shapes.medium, color = Color.White)
        .shadow(8.dp),
        onClick = {}) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
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