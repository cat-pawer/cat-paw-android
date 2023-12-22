package com.catpaw.ui.recruit

import com.catpaw.recruit.model.Project

data class RecruitUiState(
    val searchKeyword: String = "",
    val newestRecruitList: List<Project> = listOf(),
    val oldestRecruitList: List<Project> = listOf(),
    val allRecruitList: List<Project> = listOf(),
)
