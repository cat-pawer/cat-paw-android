package com.catpaw.recruit.model

data class RecruitDetail(
    val introduce: String = "설명",
    val onlineType: OnlineType = OnlineType.COMPOSITE,
    val state: String = "모집 상태",
    val viewCount: Int = 0,
    val recruitType: RecruitType = RecruitType.PROJECT,
    val title: String = "제목",
    val content: String = "컨텐트",
    val contact: String = "연락 방법",
    val peopleNumber: Int = 0,
    val tagList: List<Any> = listOf(),
    val positionList: List<Any> = listOf(),
    val techList: List<Any> = listOf(),
    val expectDuration: Int = 0,
    val recruitPeriod: String = "00.00.00",
    val createdBy: String = "이름",
    val created: String = "00.00.00",
)
