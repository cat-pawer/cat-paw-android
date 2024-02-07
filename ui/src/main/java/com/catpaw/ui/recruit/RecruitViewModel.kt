package com.catpaw.ui.recruit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catpaw.recruit.model.RecruitState
import com.catpaw.recruit.model.SearchTopic
import com.catpaw.recruit.usecase.GetProjectListBySearchUseCase
import com.catpaw.recruit.usecase.GetProjectListByTopicsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class RecruitViewModel @Inject constructor(
    private val getProjectListBySearchUseCase: GetProjectListBySearchUseCase,
    private val getProjectListByTopicsUseCase: GetProjectListByTopicsUseCase,
) : ViewModel() {
    private val _uiState = MutableRecruitUiState()
    val uiState: RecruitUiState = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getProjectListByTopicsUseCase(
                topic = SearchTopic.IS_NEW,
                state = RecruitState.ACTIVE,
                period = LocalDate.now(),
                page = 0,
                size = 10,
            ).collectLatest { result ->
                result.onSuccess { list ->
                    _uiState.newestRecruitList = list
                }
            }
        }
    }

    fun changeSearchKeyword(newKeyword: String) {
        _uiState.searchKeyword = newKeyword
    }
}