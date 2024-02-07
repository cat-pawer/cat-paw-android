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
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.catpaw.recruit.model.Category
import com.catpaw.recruit.model.Project
import com.catpaw.ui.AppBarState
import com.catpaw.ui.common.AppBarText
import com.catpaw.ui.common.SkillChip
import com.catpaw.ui.theme.CatpawandroidTheme
import com.catpaw.ui.theme.Seagull

@Preview(showBackground = true, device = "id:pixel_7_pro")
@Composable
fun RecruitScreenPreview() {
    CatpawandroidTheme {
        Surface(Modifier.fillMaxWidth()) {
            RecruitScreen(
                onRecruitDetailClick = {},
                changeSearchKeyword = {},
                modifier = Modifier.padding(PaddingValues(top = 16.dp)),
                recruitUiState = RecruitUiState()
            )
        }
    }
}

@Composable
fun RecruitRoute(
    modifier: Modifier = Modifier,
    changeAppBarState: (AppBarState) -> Unit,
    onRecruitDetailClick: (Int) -> Unit,
    recruitViewModel: RecruitViewModel = hiltViewModel(),
) {
    val recruitUiState by recruitViewModel.uiState.collectAsState()
    RecruitScreen(
        onRecruitDetailClick = onRecruitDetailClick,
        recruitUiState = recruitUiState,
        changeSearchKeyword = recruitViewModel::changeSearchKeyword,
        modifier = modifier,
    )
    val owner by rememberUpdatedState(newValue = LocalLifecycleOwner.current)
    LaunchedEffect(owner.lifecycle.currentState == Lifecycle.State.RESUMED) {
        changeAppBarState(
            AppBarState(
                title = { AppBarText("") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Rounded.AccountCircle, contentDescription = "Profile Button")
                    }
                }
            )
        )
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
    onRecruitDetailClick: (Int) -> Unit,
    changeSearchKeyword: (String) -> Unit,
    modifier: Modifier = Modifier,
    recruitUiState: RecruitUiState,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        item {
            RecruitTitle(Modifier)
            SearchField(
                modifier = Modifier,
                value = recruitUiState.searchKeyword,
                onValueChange = changeSearchKeyword,
            )
            SpacerLow()
            ProjectsRow(
                title = "신상 프로젝트",
                projects = exampleProjectList,
                onClickCard = onRecruitDetailClick,
                modifier = Modifier.padding(vertical = 4.dp),
            )
            SpacerMedium()
            ProjectsRow(
                title = "마감임박 프로젝트",
                projects = exampleProjectList,
                backgroundColor = Seagull,
                onClickCard = onRecruitDetailClick,
                modifier = Modifier.padding(vertical = 4.dp),
            )
            SpacerMedium()
        }
        items(exampleProjectList) {
            ProjectCard(
                project = it,
                onClickCard = onRecruitDetailClick,
            )
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
    val keyboard = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = "검색어") },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onSearch = { keyboard?.hide() }
        )
    )
}

@Composable
fun ProjectsColumn(
    projects: List<Project>,
    onClickCard: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 8.dp),
    ) {
        items(projects) { project ->
            ProjectCard(project = project, onClickCard = onClickCard)
        }
    }
}

@Composable
fun ProjectsRow(
    title: String,
    projects: List<Project>,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    onClickCard: (Int) -> Unit,
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
                ProjectCard(project = project, onClickCard = onClickCard)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectsRowPreview() {
    ProjectsRow("title", exampleProjectList, onClickCard = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectCard(project: Project, onClickCard: (Int) -> Unit) {
    ElevatedCard(modifier = Modifier
        .padding(vertical = 4.dp)
        .size(width = 280.dp, height = 180.dp)
        .border(1.dp, shape = MaterialTheme.shapes.medium, color = Color.White)
        .shadow(8.dp),
        onClick = { onClickCard(project.id) }) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Row {
                for (tag in project.tags) {
                    Text(
                        text = "#${tag.name} ", color = Color(0xFFC5C5C5)
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
                    SkillChip(skill = skill.name)
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

private val tagsExample = listOf(
    Category(id = 1, name = "디자이나", value = null, categoryType = "hash"),
    Category(id = 2, name = "백엔드", value = null, categoryType = "hash"),
    Category(id = 3, name = "프론트엔드", value = null, categoryType = "hash")
)

private val skillsExample = listOf(
    Category(id = 1, name = "Java", value = null, categoryType = "tech"),
    Category(id = 2, name = "Spring", value = null, categoryType = "tech"),
    Category(id = 3, name = "Kotlin", value = null, categoryType = "tech"),
)

private val exampleProjectList = listOf(
    Project(
        title = "et51n2nnnt2nt2".repeat(5),
        tags = tagsExample,
        replyCount = 9293,
        viewCount = 3867,
        skills = skillsExample,
        id = 1
    ), Project(
        title = "etanewtntewa".repeat(10),
        tags = tagsExample,
        replyCount = 9293,
        viewCount = 3867,
        skills = skillsExample,
        id = 2
    ), Project(
        title = "et",
        tags = tagsExample,
        replyCount = 9293,
        viewCount = 3867,
        skills = skillsExample,
        id = 3
    ), Project(
        title = "pulvinar",
        tags = tagsExample,
        replyCount = 1442,
        viewCount = 8213,
        skills = skillsExample,
        id = 4
    ), Project(
        title = "pulvinar",
        tags = tagsExample,
        replyCount = 1442,
        viewCount = 8213,
        skills = skillsExample,
        id = 5
    ), Project(
        title = "pulvinar",
        tags = tagsExample,
        replyCount = 1442,
        viewCount = 8213,
        skills = skillsExample,
        id = 6
    ), Project(
        title = "pulvinar",
        tags = tagsExample,
        replyCount = 1442,
        viewCount = 8213,
        skills = skillsExample,
        id = 7
    )
)

@Composable
fun EmptyProjectList(
    modifier: Modifier = Modifier,
    height: Int = 180,
) {
    Text(
        text = "프로젝트가 없습니다.",
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(height.dp),
    )
}