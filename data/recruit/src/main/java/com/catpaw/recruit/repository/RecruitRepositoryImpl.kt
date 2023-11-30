package com.catpaw.recruit.repository

import com.catpaw.recruit.model.Project
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecruitRepositoryImpl @Inject constructor() : RecruitRepository {
    override fun getRecruitList(): Flow<Result<List<Project>>> = flow {
        emit(
            Result.success(
                listOf(
                    Project(
                        title = "",
                        tags = listOf(),
                        replyCount = 0,
                        viewCount = 0,
                        skills = listOf(),
                        ),
                    Project(
                        title = "",
                        tags = listOf(),
                        replyCount = 0,
                        viewCount = 0,
                        skills = listOf(),
                    ),
                )
            )
        )
    }
}