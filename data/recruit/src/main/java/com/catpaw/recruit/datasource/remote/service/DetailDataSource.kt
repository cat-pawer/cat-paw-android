package com.catpaw.recruit.datasource.remote.service

import com.catpaw.recruit.dto.CatPawResponse
import com.catpaw.recruit.dto.RecruitDetailResponse
import kotlinx.coroutines.flow.Flow

interface DetailDataSource {
    fun getDetail(id: Int): Flow<Result<CatPawResponse<RecruitDetailResponse>>>
}