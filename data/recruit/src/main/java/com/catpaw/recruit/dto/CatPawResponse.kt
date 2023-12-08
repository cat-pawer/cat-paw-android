package com.catpaw.recruit.dto

import com.google.gson.annotations.SerializedName

data class CatPawResponse<T>(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: T,
)
