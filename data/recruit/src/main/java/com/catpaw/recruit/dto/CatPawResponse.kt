package com.catpaw.recruit.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatPawResponse<T>(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String?,
    @SerialName("data")
    val data: T,
)
