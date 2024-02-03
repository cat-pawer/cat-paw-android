package com.catpaw.recruit.datasource.remote

import com.catpaw.recruit.dto.response.CatPawResponse
import com.catpaw.recruit.dto.response.CommentListResponse
import com.catpaw.recruit.dto.response.RecruitDetailResponse
import kotlinx.coroutines.flow.Flow

interface DetailDataSource {
    fun getDetail(id: Int): Flow<Result<CatPawResponse<RecruitDetailResponse>>>

    fun getCommentList(id: Int): Flow<Result<CatPawResponse<CommentListResponse>>>
}