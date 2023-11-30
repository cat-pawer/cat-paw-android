package com.catpaw.ui.recruit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catpaw.recruit.usecase.GetProjectListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruitViewModel @Inject constructor(
    private val getProjectListUseCase: GetProjectListUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecruitUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getProjectListUseCase().collect {
                Log.d("RecruitViewModel", "init: $it")
            }
        }
    }

    fun changeSearchKeyword(newKeyword: String) {
        _uiState.update { currentState ->
            currentState.copy(searchKeyword = newKeyword)
        }
    }
}