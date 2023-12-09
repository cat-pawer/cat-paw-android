package com.catpaw.recruit.repository

import com.catpaw.recruit.model.RecruitComment
import com.catpaw.recruit.model.RecruitDetail
import kotlinx.coroutines.flow.Flow

interface DetailRepository {
    fun getDetail(id: Int): Flow<Result<RecruitDetail>>

    fun getCommentList(id:Int): Flow<Result<List<RecruitComment>>>
}
