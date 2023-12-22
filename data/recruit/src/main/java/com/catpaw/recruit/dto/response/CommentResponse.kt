package com.catpaw.recruit.dto.response

import com.catpaw.recruit.model.RecruitComment
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class CommentResponse(
    @SerialName("content")
    val content: String,
    @SerialName("id")
    val id: Int,
    @SerialName("memberId")
    val memberId: Int,
    @SerialName("nickname")
    val nickname: String?
) {
    fun toDomain() = RecruitComment(
        contentId = id,
        memberId = memberId,
        nickname = nickname ?: "닉네임",
        content = content,
    )
}