package com.catpaw.recruit.dto

import com.catpaw.recruit.model.RecruitComment
import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @SerializedName("content")
    val content: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("memberId")
    val memberId: Int,
    @SerializedName("nickname")
    val nickname: String?
) {
    fun toDomain() = RecruitComment(
        contentId = id,
        memberId = memberId,
        nickname = nickname ?: "",
        content = content,
    )
}