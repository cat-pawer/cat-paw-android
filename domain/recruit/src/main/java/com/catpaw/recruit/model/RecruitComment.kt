package com.catpaw.recruit.model

data class RecruitComment(
    val contentId: Int = -1,
    val memberId: Int = -1,
    val nickname: String = "",
    val content: String = "",
)
