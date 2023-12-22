package com.catpaw.recruit.model

enum class RecruitType(
    val korean: String
) {
    PROJECT("프로젝트"), STUDY("스터디");

    val query get() = this.name.lowercase()
}