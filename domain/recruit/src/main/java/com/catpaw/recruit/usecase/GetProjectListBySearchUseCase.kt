package com.catpaw.recruit.usecase

import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.Project
import com.catpaw.recruit.model.RecruitState
import com.catpaw.recruit.model.RecruitType
import com.catpaw.recruit.repository.SummaryRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class GetProjectListBySearchUseCase @Inject constructor(
    private val repository: SummaryRepository,
) {
    operator fun invoke(
        searchValue: String,
        recruitType: RecruitType,
        onlineType: OnlineType,
        categoryIdList: Array<Int>,
        state: RecruitState,
        period: LocalDate = LocalDate.now(),
        page: Int,
        size: Int,
        vararg sort: String = arrayOf("created"),
    ): Flow<Result<List<Project>>> {
        return repository.getRecruitListBySearch(
            searchValue = searchValue,
            recruitType = recruitType,
            onlineType = onlineType,
            categoryIdList = categoryIdList,
            state = state,
            period = period,
            page = page,
            size = size,
            sort = sort,
        )
    }
}