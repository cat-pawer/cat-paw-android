package com.catpaw.recruit.dto


import com.google.gson.annotations.SerializedName

data class RecruitDetailResponse(
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("contact")
    val contact: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("createdBy")
    val createdBy: Int,
    @SerializedName("expectDuration")
    val expectDuration: Int,
    @SerializedName("groupType")
    val groupType: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("onlineType")
    val onlineType: String,
    @SerializedName("peopleNumber")
    val peopleNumber: Int,
    @SerializedName("positionList")
    val positionList: List<PositionResponse>,
    @SerializedName("recruitPeriod")
    val recruitPeriod: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("tagList")
    val tagList: List<TagResponse>,
    @SerializedName("techList")
    val techList: List<TechResponse>,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated")
    val updated: String,
    @SerializedName("updatedBy")
    val updatedBy: Int,
    @SerializedName("viewCount")
    val viewCount: Int
)