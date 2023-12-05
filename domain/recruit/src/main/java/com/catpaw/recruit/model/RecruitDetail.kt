package com.catpaw.recruit.model

data class RecruitDetail(
    val introduce: String,
    val onlineType: OnlineType,
    val state: String,
    val viewCount: Int,
    val recruitType: RecruitType,
    val title: String,
    val content: String,
    val contact: String,
    val peopleNumber: Int,
    val tagList: List<Any>,
    val positionList: List<Any>,
    val techList: List<Any>,
    val expectDuration: Int,
    val recruitPeriod: String,
)
