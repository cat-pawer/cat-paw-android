package com.catpaw.recruit.model

data class Project(
    val title: String,
    val tags: List<Category>,
    val replyCount: Int,
    val viewCount: Int,
    val skills: List<Category>,
    val id: Int,
)
