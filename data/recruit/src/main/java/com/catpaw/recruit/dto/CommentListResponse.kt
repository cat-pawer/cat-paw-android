package com.catpaw.recruit.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommentListResponse(
    @SerialName("content")
    val commentList: List<CommentResponse>,
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
    val totalPages: Int
)