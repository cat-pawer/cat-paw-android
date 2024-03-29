package com.catpaw.recruit.datasource.remote

import com.catpaw.recruit.dto.response.CatPawResponse
import com.catpaw.recruit.dto.response.RecruitSummaryResponse
import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.RecruitState
import com.catpaw.recruit.model.RecruitType
import com.catpaw.recruit.model.SearchTopic
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface SummaryLocalDataSource {
    fun getRecruitListByTopics(
        topic: SearchTopic,
        state: RecruitState,
        period: LocalDate = LocalDate.now(),
        page: Int = 0,
        size: Int = 10,
        vararg sort: String = arrayOf("created"),
    ): Flow<Result<CatPawResponse<RecruitSummaryResponse>>>

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
    ): Flow<Result<CatPawResponse<RecruitSummaryResponse>>>
}