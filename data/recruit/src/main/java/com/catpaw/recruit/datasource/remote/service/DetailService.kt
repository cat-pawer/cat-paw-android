package com.catpaw.recruit.datasource.remote.service

import com.catpaw.recruit.dto.CatPawResponse
import com.catpaw.recruit.dto.RecruitDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailService {
    @GET("recruit/detail/{id}")
    suspend fun fetchRecruitDetail(@Path("id") id: Int): Response<CatPawResponse<RecruitDetailResponse>>
}