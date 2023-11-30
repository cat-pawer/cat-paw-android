package com.catpaw.recruit.repository

import com.catpaw.recruit.model.Project
import kotlinx.coroutines.flow.Flow

interface RecruitRepository {
    fun getRecruitList(): Flow<Result<List<Project>>>
}