package com.catpaw.recruit.dto.response


import com.catpaw.recruit.dto.TechResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecruitSummaryElemResponse(
    @SerialName("commentCount")
    val commentCount: Int,
    @SerialName("hashList")
    val hashList: List<HashResponse>,
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
    val techList: List<TechResponse>,
    @SerialName("title")
    val title: String,
    @SerialName("viewCount")
    val viewCount: Int
)