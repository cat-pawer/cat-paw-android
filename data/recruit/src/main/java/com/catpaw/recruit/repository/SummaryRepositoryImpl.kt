package com.catpaw.recruit.repository

import com.catpaw.recruit.datasource.remote.SummaryLocalDataSource
import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.Project
import com.catpaw.recruit.model.RecruitState
import com.catpaw.recruit.model.RecruitType
import com.catpaw.recruit.model.SearchTopic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject

class SummaryRepositoryImpl @Inject constructor(
    private val summaryLocalDataSource: SummaryLocalDataSource,
) : SummaryRepository {
    override fun getRecruitListByTopics(
        topic: SearchTopic,
        state: RecruitState,
        period: LocalDate,
        page: Int,
        size: Int,
        vararg sort: String,
    ): Flow<Result<List<Project>>> {
        return summaryLocalDataSource.getRecruitListByTopics(
            topic = topic, state = state, period = period, page = page, size = size
        ).map { result ->
            result.map { response ->
                response.data.toDomain()
            }
        }
    }

    override fun getRecruitListBySearch(
        searchValue: String,
        recruitType: RecruitType,
        onlineType: OnlineType,
        categoryIdList: Array<Int>,
        state: RecruitState,
        period: LocalDate,
        page: Int,
        size: Int,
        vararg sort: String,
    ): Flow<Result<List<Project>>> {
        return summaryLocalDataSource.getRecruitListBySearch(
            searchValue = searchValue,
            recruitType = recruitType,
            onlineType = onlineType,
            categoryIdList = categoryIdList,
            state = state,
            period = period,
            page = page,
            size = size
        ).map { result ->
            result.map { response ->
                response.data.toDomain()
            }
        }
    }
}