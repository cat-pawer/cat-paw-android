package com.catpaw.recruit.repository

import com.catpaw.recruit.datasource.remote.DetailDataSource
import com.catpaw.recruit.dto.response.CommentResponse
import com.catpaw.recruit.model.RecruitComment
import com.catpaw.recruit.model.RecruitDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val detailDataSource: DetailDataSource
) : DetailRepository {
    override fun getDetail(id: Int): Flow<Result<RecruitDetail>> {
        return detailDataSource.getDetail(id).map { result ->
            result.map { response ->
                response.data.toDomain()
            }
        }
    }

    override fun getCommentList(id: Int): Flow<Result<List<RecruitComment>>> {
        return detailDataSource.getCommentList(id).map { result ->
            result.map { list ->
                list.data.commentList.map(CommentResponse::toDomain)
            }
        }
    }
}