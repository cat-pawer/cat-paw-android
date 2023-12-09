package com.catpaw.ui.recruitdetail

import com.catpaw.recruit.model.RecruitComment
import com.catpaw.recruit.model.RecruitDetail

data class RecruitDetailUiState(
    val recruitDetail: RecruitDetail = RecruitDetail(),
    val commentList: List<RecruitComment> = listOf(),
    val inputComment: String = "",
    val recruitId: Int = -1,
)
