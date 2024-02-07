package com.catpaw.recruit.usecase

import com.catpaw.recruit.model.Project
import com.catpaw.recruit.model.RecruitState
import com.catpaw.recruit.model.SearchTopic
import com.catpaw.recruit.repository.SummaryRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class GetProjectListByTopicsUseCase @Inject constructor(
    private val repository: SummaryRepository,
) {
    operator fun invoke(
        topic: SearchTopic,
        state: RecruitState,
        period: LocalDate,
        page: Int,
        size: Int,
        vararg sort: String,
    ): Flow<Result<List<Project>>> {
        return repository.getRecruitListByTopics(
            topic = topic,
            state = state,
            period = period,
            page = page,
            size = size,
            sort = sort,
        )
    }
}