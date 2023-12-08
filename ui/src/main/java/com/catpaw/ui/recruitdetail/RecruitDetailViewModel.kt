package com.catpaw.ui.recruitdetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RecruitDetailViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow(RecruitDetailUiState())
    val uiState = _uiState.asStateFlow()

    fun changeInputComment(change: String) {
        _uiState.update { state ->
            state.copy(inputComment = change)
        }
    }
}