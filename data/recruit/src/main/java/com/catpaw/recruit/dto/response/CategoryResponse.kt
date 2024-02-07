package com.catpaw.recruit.dto.response


import com.catpaw.recruit.model.Category
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
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
) {
    fun toDomain() = Category(
        id = categoryId,
        name = name,
        value = value,
        categoryType = categoryType
    )
}