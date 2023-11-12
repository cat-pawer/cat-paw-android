package com.example.cat_paw_android.model

data class Project(
    val title: String,
    val tags: List<String>,
    val replyCount: Int,
    val viewCount: Int,
    val skills: List<String>,
)
