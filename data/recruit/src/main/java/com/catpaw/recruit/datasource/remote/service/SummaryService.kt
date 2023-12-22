package com.catpaw.recruit.datasource.remote.service

import com.catpaw.recruit.dto.response.CatPawResponse
import com.catpaw.recruit.dto.response.RecruitSummaryResponse
import com.catpaw.recruit.model.RecruitType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SummaryService {
    //신상 또는 마감임박 프로젝트 페이지 또는 스크롤 조회
    @GET("recruit/summary/topics")
    suspend fun fetchRecruitSummaryByTopics(
        @Query("topic") topic: String,
        @Query("state") recruitState: String,
        @Query("isPage") isPage: Boolean = false,
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") vararg sort: String = arrayOf("created"),
    ): Response<CatPawResponse<RecruitSummaryResponse>>

    //전체 프로젝트 필터 페이지 또는 스크롤 조회
    @GET("recruit/summary/search")
    suspend fun fetchRecruitSummaryBySearch(
        @Query("searchValue") searchValue: String,
        @Query("recruitType") recruitType: String,
        @Query("onlineType") onlineType: String,
        @Query("categoryIdList") categoryIdList: Array<Int>,
        @Query("recruitState") recruitState: String,
        @Query("isPage") isPage: Boolean = false,
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") vararg sort: String = arrayOf("created"),
    ): Response<CatPawResponse<RecruitSummaryResponse>>
}