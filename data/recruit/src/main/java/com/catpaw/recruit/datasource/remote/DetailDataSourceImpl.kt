package com.catpaw.recruit.datasource.remote

import com.catpaw.recruit.datasource.remote.service.DetailService
import com.catpaw.recruit.dto.CatPawResponse
import com.catpaw.recruit.dto.CommentListRequest
import com.catpaw.recruit.dto.CommentListResponse
import com.catpaw.recruit.dto.RecruitDetailResponse
import kotlinx.coroutines.flow.Flow
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

    override fun getCommentList(id: Int): Flow<Result<CatPawResponse<CommentListResponse>>> = flow {
        val response = detailService.fetchDetailComment(id, CommentListRequest())
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