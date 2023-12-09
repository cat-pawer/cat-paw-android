package com.catpaw.recruit.dto


import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.RecruitDetail
import com.catpaw.recruit.model.RecruitType
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
    val viewCount: Int,
) {
    fun toDomain() = RecruitDetail(
        introduce = "introduce",
        onlineType = OnlineType.valueOf(onlineType),
        state = state,
        viewCount = viewCount,
        recruitType = RecruitType.valueOf(groupType),
        title = title,
        content = content,
        contact = contact,
        peopleNumber = peopleNumber,
        tagList = tagList.map { it.name },
        positionList = positionList.map { it.name },
        techList = techList.map { it.name },
        expectDuration = expectDuration,
        recruitPeriod = recruitPeriod,
        createdBy = createdBy.toString(),
        created = created,
    )
}