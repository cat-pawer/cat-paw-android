package com.catpaw.ui.recruit

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.catpaw.recruit.model.Project

@Stable
interface RecruitUiState {
    val searchKeyword: String
    val newestRecruitList: List<Project>
    val oldestRecruitList: List<Project>
    val allRecruitList: List<Project>
}

internal class MutableRecruitUiState : RecruitUiState {
    override var searchKeyword: String by mutableStateOf("")
    override var newestRecruitList: List<Project> = mutableStateListOf(*arrayOf())
    override var oldestRecruitList: List<Project> = mutableStateListOf(*arrayOf())
    override var allRecruitList: List<Project> = mutableStateListOf(*arrayOf())
}