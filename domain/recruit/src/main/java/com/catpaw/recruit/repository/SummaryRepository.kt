package com.catpaw.recruit.repository

import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.Project
import com.catpaw.recruit.model.RecruitState
import com.catpaw.recruit.model.RecruitType
import com.catpaw.recruit.model.SearchTopic
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface SummaryRepository {
    fun getRecruitListByTopics(
        topic: SearchTopic,
        state: RecruitState,
        period: LocalDate = LocalDate.now(),
        page: Int = 0,
        size: Int = 10,
        vararg sort: String = arrayOf("created"),
    ): Flow<Result<List<Project>>>

    fun getRecruitListBySearch(
        searchValue: String,
        recruitType: RecruitType,
        onlineType: OnlineType,
        categoryIdList: Array<Int>,
        state: RecruitState,
        period: LocalDate = LocalDate.now(),
        page: Int = 0,
        size: Int = 10,
        vararg sort: String = arrayOf("created"),
    ): Flow<Result<List<Project>>>
}