package com.catpaw.recruit.datasource.remote.service

import com.catpaw.recruit.dto.CatPawResponse
import com.catpaw.recruit.dto.RecruitDetailResponse
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailDataSourceImpl @Inject constructor(
    private val detailService: DetailService
) : DetailDataSource {
    override fun getDetail(id: Int) = flow<Result<CatPawResponse<RecruitDetailResponse>>> {
        val response = detailService.fetchRecruitDetail(id)
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