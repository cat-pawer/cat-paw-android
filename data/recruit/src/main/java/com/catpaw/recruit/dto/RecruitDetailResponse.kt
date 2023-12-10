package com.catpaw.recruit.dto


import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.RecruitDetail
import com.catpaw.recruit.model.RecruitType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecruitDetailResponse(
    @SerialName("commentCount")
    val commentCount: Int,
    @SerialName("contact")
    val contact: String,
    @SerialName("content")
    val content: String,
    @SerialName("created")
    val created: String,
    @SerialName("createdBy")
    val createdBy: Int?,
    @SerialName("expectDuration")
    val expectDuration: Int,
    @SerialName("groupType")
    val groupType: String,
    @SerialName("id")
    val id: Int,
    @SerialName("onlineType")
    val onlineType: String,
    @SerialName("peopleNumber")
    val peopleNumber: Int,
    @SerialName("positionList")
    val positionList: List<PositionResponse>,
    @SerialName("recruitPeriod")
    val recruitPeriod: String,
    @SerialName("state")
    val state: String,
    @SerialName("tagList")
    val tagList: List<TagResponse>,
    @SerialName("techList")
    val techList: List<TechResponse>,
    @SerialName("title")
    val title: String,
    @SerialName("updated")
    val updated: String,
    @SerialName("updatedBy")
    val updatedBy: Int?,
    @SerialName("viewCount")
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