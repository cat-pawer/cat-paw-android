package com.catpaw.ui.recruitdetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catpaw.recruit.usecase.GetCommentListUseCase
import com.catpaw.recruit.usecase.GetDetailUseCase
import com.catpaw.ui.NAV_PATH_VAR_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruitDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getDetailUseCase: GetDetailUseCase,
    private val getCommentListUseCase: GetCommentListUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecruitDetailUiState())
    val uiState = _uiState.asStateFlow()

    private val userId: Int = requireNotNull(savedStateHandle[NAV_PATH_VAR_ID])

    init {
        loadData(userId)
    }

    fun changeInputComment(change: String) {
        _uiState.update { state ->
            state.copy(inputComment = change)
        }
    }

    private fun loadData(id: Int) {
        if (_uiState.value.recruitId != id) {
            _uiState.update { state ->
                state.copy(recruitId = id)
            }
            Log.d("RecruitDetailViewModel", "loadData: ${_uiState.value.recruitId} $id")
            loadRecruitDetail(id)
            loadRecruitCommentList(id)
        }
    }

    private fun loadRecruitDetail(id: Int) {
        viewModelScope.launch {
            getDetailUseCase(id).collect { result ->
                result.onSuccess { detail ->
                    _uiState.update { state ->
                        state.copy(recruitDetail = detail)
                    }
                }.onFailure {
                    Log.d("RecruitDetailViewModel", "getRecruitDetail: $it")
                }
            }
        }
    }

    private fun loadRecruitCommentList(id: Int) {
        viewModelScope.launch {
            getCommentListUseCase(id).collect { result ->
                result.onSuccess { commentList ->
                    _uiState.update { state ->
                        state.copy(commentList = commentList)
                    }
                }.onFailure {
                    Log.d("RecruitDetailViewModel", "getRecruitDetail: $it")
                }
            }
        }
    }
}
