package com.catpaw.ui.recruitdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.RecruitComment
import com.catpaw.recruit.model.RecruitDetail
import com.catpaw.recruit.model.RecruitType
import com.catpaw.ui.AppBarState
import com.catpaw.ui.common.AppBarText
import com.catpaw.ui.common.ContentText
import com.catpaw.ui.common.NavButtonDefault
import com.catpaw.ui.common.RecruitTypeChip
import com.catpaw.ui.common.SmallContentGrayText
import com.catpaw.ui.common.SmallContentText
import com.catpaw.ui.common.SubTitleText
import com.catpaw.ui.common.TitleText
import com.catpaw.ui.recruit.SpacerLow
import com.catpaw.ui.recruit.SpacerMedium
import com.catpaw.ui.theme.Alabaster
import com.catpaw.ui.theme.CatpawandroidTheme
import com.catpaw.ui.theme.Seagull

@Composable
fun RecruitDetailRoute(
    changeAppBarState: (AppBarState) -> Unit,
    modifier: Modifier = Modifier,
    onNavClick: () -> Unit = {},
    detailViewModel: RecruitDetailViewModel = hiltViewModel(),
) {
    val owner by rememberUpdatedState(newValue = LocalLifecycleOwner.current)
    LaunchedEffect(owner.lifecycle.currentState == Lifecycle.State.RESUMED) {
        changeAppBarState(
            AppBarState(
                title = { AppBarText(text = "모집 상세") },
                navigationIconButton = { NavButtonDefault(onNavClick) }
            )
        )
    }
    val uiState by detailViewModel.uiState.collectAsState()
    RecruitDetailScreen(
        uiState = uiState,
        changeInputComment = detailViewModel::changeInputComment,
        modifier = modifier,
    )
}

@Composable
fun RecruitDetailScreen(
    uiState: RecruitDetailUiState,
    changeInputComment: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val recruitDetail = uiState.recruitDetail
    val commentList = uiState.commentList
    LazyColumn(modifier = modifier) {
        item {
            RecruitDetailTitle(recruitDetail = recruitDetail)
            SpacerMedium()
            RecruitContactBox(recruitDetail = recruitDetail)
            SpacerMedium()
            RecruitContent(recruitDetail = recruitDetail)
            SpacerMedium()
            RecruitCommentInput(
                value = uiState.inputComment,
                onValueChange = changeInputComment
            )
            SpacerMedium()
        }
        if (commentList.isEmpty()) {
            item {
                Text(
                    text = "댓글이 없습니다.",
                    modifier = modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                )
            }
        } else {
            itemsIndexed(commentList) { index, comment ->
                RecruitCommentBox(comment = comment)
                if (index < commentList.lastIndex) {
                    SpacerLow()
                    Divider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.LightGray,
                        thickness = 1.dp,
                    )
                }
            }
        }
    }
}

@Composable
fun RecruitDetailTitle(
    recruitDetail: RecruitDetail,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        RecruitTypeChip(recruitType = recruitDetail.recruitType)
        TitleText(text = recruitDetail.title)
        SpacerLow()
        RecruitDetailTitleInfo(recruitDetail = recruitDetail)
    }
}

@Composable
fun RecruitDetailTitleInfo(
    recruitDetail: RecruitDetail,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        ContentText(text = recruitDetail.createdBy, color = Color.Gray)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            SmallContentGrayText(text = "등록: ${recruitDetail.created}")
            SmallContentGrayText(text = "조회수: ${recruitDetail.viewCount}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecruitDetailTitlePreview() {
    RecruitDetailTitle(exampleRecruitDetail)
}

@Composable
fun RecruitContactBox(
    recruitDetail: RecruitDetail,
    modifier: Modifier = Modifier,
) {
    val configure = LocalConfiguration.current
    val innerRowModifier = Modifier.width((configure.screenWidthDp * 0.4).dp)
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Seagull,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IntroduceInnerRow("모집 인원", recruitDetail.recruitPeriod, innerRowModifier)
            IntroduceInnerRow("예상 기간", "${recruitDetail.expectDuration}개월", innerRowModifier)
        }
        SpacerLow()
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceAround
        ) {
            IntroduceInnerRow("연락 방법", recruitDetail.contact, innerRowModifier)
            IntroduceInnerRow("진행 방식", recruitDetail.onlineType.korean, innerRowModifier)
        }
    }
}

@Composable
fun IntroduceInnerRow(
    type: String,
    data: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        SmallContentGrayText(text = type)
        SpacerLow()
        SmallContentText(text = data)
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun RecruitContactBoxPreview() {
    RecruitContactBox(
        recruitDetail = exampleRecruitDetail,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun RecruitContent(recruitDetail: RecruitDetail) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    Column(
        modifier = Modifier
            .requiredWidth(screenWidth.dp)
            .background(Alabaster)
            .padding(vertical = 32.dp, horizontal = 16.dp)
    ) {
        SubTitleText("프로젝트 소개")
        SpacerLow()
        Box(
        ) {
            Text(recruitDetail.introduce)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecruitContentPreview() {
    Box(Modifier.padding(horizontal = 4.dp)) {
        RecruitContent(exampleRecruitDetail)
    }
}

@Composable
fun RecruitCommentInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column {
        SubTitleText(text = "댓글")
        SpacerLow()
        Row(
            modifier = Modifier
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(8.dp),
                )
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically,
        ) {
            OutlinedTextField(
                modifier = modifier
                    .weight(1f),
                value = value,
                placeholder = { Text(text = "댓글을 입력해주세요.") },
                onValueChange = onValueChange,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Default
                ),
                keyboardActions = KeyboardActions(
                    onDone = { }
                )
            )
            Button(
                modifier = Modifier.padding(top = 4.dp, end = 4.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "등록")
            }
        }
    }
}

@Composable
fun CommentTextField(
    modifier: Modifier,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
) {

}

@Preview(showBackground = true)
@Composable
fun RecruitCommentInputPreview() {
    CatpawandroidTheme {
        Surface {
            RecruitCommentInput(value = "", onValueChange = {})
        }
    }
}

@Composable
fun RecruitCommentBox(
    comment: RecruitComment,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
        ) {
            ContentText(text = comment.nickname, fontWeight = FontWeight.SemiBold)
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "댓글 삭제",
                modifier = Modifier.clickable { }
            )
        }
        SpacerLow()
        SmallContentText(text = comment.content)
    }
}

@Composable
fun RecruitComments(
    commentList: List<RecruitComment>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
//        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        itemsIndexed(commentList) { index, comment ->
            RecruitCommentBox(comment = comment)
            if (index < commentList.lastIndex) {
                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = Color.LightGray,
                    thickness = 1.dp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecruitCommentBoxPreview() {
    RecruitCommentBox(comment = exampleRecruitComment, modifier = Modifier.fillMaxWidth(0.7f))
}

@Preview(showBackground = true)
@Composable
fun RecruitCommentsPreview() {
    RecruitComments(
        commentList = List(5) { exampleRecruitComment },
        modifier = Modifier.padding(8.dp),
    )
}

private val exampleRecruitDetail = RecruitDetail(
    introduce = "mutat",
    onlineType = OnlineType.COMPOSITE,
    state = "Vermont",
    viewCount = 2248,
    recruitType = RecruitType.PROJECT,
    title = "프로젝트 제목입니다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ",
    content = "프로젝트 컨텐트?????",
    contact = "오픈톡",
    peopleNumber = 2,
    tagList = listOf("태그1", "태그2"),
    positionList = listOf("분야1", "분야2"),
    techList = listOf("기술1", "기술2"),
    expectDuration = 5,
    recruitPeriod = "23.12.22"
)

private val exampleRecruitComment = RecruitComment(
    contentId = 5,
    memberId = 3,
    nickname = "닉네임",
    content = "댓글 내용입니다. ".repeat(5),
)