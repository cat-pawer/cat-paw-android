package com.catpaw.ui.recruit

import androidx.lifecycle.ViewModel
import com.catpaw.recruit.usecase.GetProjectListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RecruitViewModel @Inject constructor(
    private val getProjectListUseCase: GetProjectListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecruitUiState())
    val uiState = _uiState.asStateFlow()

    fun changeSearchKeyword(newKeyword: String) {
        _uiState.update { currentState ->
            currentState.copy(searchKeyword = newKeyword)
        }
    }
}