package com.catpaw.recruit.dto.response


import com.catpaw.recruit.model.Project
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecruitSummaryResponse(
    @SerialName("content")
    val content: List<RecruitSummaryElemResponse>,
    @SerialName("hasNext")
    val hasNext: Boolean,
    @SerialName("hasPrevious")
    val hasPrevious: Boolean,
    @SerialName("number")
    val number: Int,
    @SerialName("numberOfElements")
    val numberOfElements: Int,
    @SerialName("size")
    val size: Int,
    @SerialName("totalElements")
    val totalElements: Int,
    @SerialName("totalPages")
    val totalPages: Int,
) {
    fun toDomain() = content.map {
        Project(
            title = it.title,
            tags = it.hashList.map { category -> category.toDomain() },
            replyCount = it.commentCount,
            viewCount = it.viewCount,
            skills = it.techList.map { category -> category.toDomain() },
            id = it.id,
        )
    }
}