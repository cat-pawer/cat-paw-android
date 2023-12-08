package com.catpaw.recruit.dto


import com.google.gson.annotations.SerializedName

data class TagResponse(
    @SerializedName("categoryId")
    val categoryId: Int,
    @SerializedName("categoryMapperId")
    val categoryMapperId: Int,
    @SerializedName("categoryType")
    val categoryType: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("targetId")
    val targetId: Int,
    @SerializedName("targetType")
    val targetType: String,
    @SerializedName("value")
    val value: String
)