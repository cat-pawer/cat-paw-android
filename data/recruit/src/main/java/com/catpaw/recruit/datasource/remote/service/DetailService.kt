package com.catpaw.recruit.datasource.remote.service

import com.catpaw.recruit.dto.CatPawResponse
import com.catpaw.recruit.dto.CommentListRequest
import com.catpaw.recruit.dto.CommentListResponse
import com.catpaw.recruit.dto.RecruitDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface DetailService {
    @GET("recruit/detail/{id}")
    suspend fun fetchRecruitDetail(@Path("id") id: Int): Response<CatPawResponse<RecruitDetailResponse>>

    @GET("comment/summary/{id}")
    suspend fun fetchDetailComment(
        @Path("id") id: Int,
        @QueryMap request: CommentListRequest,
    ): Response<CatPawResponse<CommentListResponse>>
}