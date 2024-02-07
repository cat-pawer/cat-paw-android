package com.catpaw.recruit.datasource.remote

import com.catpaw.recruit.datasource.remote.service.SummaryService
import com.catpaw.recruit.dto.response.CatPawResponse
import com.catpaw.recruit.dto.response.RecruitSummaryResponse
import com.catpaw.recruit.model.OnlineType
import com.catpaw.recruit.model.RecruitState
import com.catpaw.recruit.model.RecruitType
import com.catpaw.recruit.model.SearchTopic
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import javax.inject.Inject

class SummaryLocalDataSourceImpl @Inject constructor(
    private val summaryService: SummaryService,
) : SummaryLocalDataSource {
    override fun getRecruitListByTopics(
        topic: SearchTopic,
        state: RecruitState,
        period: LocalDate,
        page: Int,
        size: Int,
        vararg sort: String,
    ) = flow<Result<CatPawResponse<RecruitSummaryResponse>>> {
        val response = summaryService.fetchRecruitSummaryByTopics(
            topic = topic.query, recruitState = state.query, page = page, size = size, sort = sort
        )
        if (response.isSuccessful) {
            val body = response.body()
            if (body == null) {
                emit(Result.failure(Exception("body is null")))
            } else {
                emit(Result.success(body))
            }
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string())))
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
    ) = flow<Result<CatPawResponse<RecruitSummaryResponse>>> {
        val response = summaryService.fetchRecruitSummaryBySearch(
            searchValue = searchValue,
            recruitType = recruitType.query,
            onlineType = onlineType.query,
            categoryIdList = categoryIdList,
            recruitState = state.query,
            isPage = false, //TODO: 함수가 입력 받도록 수정
            page = page,
            size = size,
            //TODO: period, sort 추가
        )
        if (response.isSuccessful) {
            val body = response.body()
            if (body == null) {
                emit(Result.failure(Exception("body is null")))
            } else {
                emit(Result.success(body))
            }
        } else {
            emit(Result.failure(Exception(response.errorBody()?.string())))
        }
    }
}