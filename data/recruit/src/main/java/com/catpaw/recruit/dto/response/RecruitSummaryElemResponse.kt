package com.catpaw.recruit.dto.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecruitSummaryElemResponse(
    @SerialName("commentCount")
    val commentCount: Int,
    @SerialName("hashList")
    val hashList: List<CategoryResponse>,
    @SerialName("id")
    val id: Int,
    @SerialName("onlineType")
    val onlineType: String,
    @SerialName("recruitPeriod")
    val recruitPeriod: String,
    @SerialName("recruitType")
    val recruitType: String,
    @SerialName("state")
    val state: String,
    @SerialName("techList")
    val techList: List<CategoryResponse>,
    @SerialName("title")
    val title: String,
    @SerialName("viewCount")
    val viewCount: Int
)