package com.catpaw.recruit.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TagResponse(
    @SerialName("categoryId")
    val categoryId: Int,
    @SerialName("categoryMapperId")
    val categoryMapperId: Int?,
    @SerialName("categoryType")
    val categoryType: String,
    @SerialName("created")
    val created: String,
    @SerialName("name")
    val name: String,
    @SerialName("targetId")
    val targetId: Int?,
    @SerialName("targetType")
    val targetType: String?,
    @SerialName("value")
    val value: String?,
)