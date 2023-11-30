package com.catpaw.recruit.usecase

import com.catpaw.recruit.model.Project
import com.catpaw.recruit.repository.RecruitRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProjectListUseCase @Inject constructor(
    private val recruitRepository: RecruitRepository
) {
    operator fun invoke(): Flow<Result<List<Project>>> {
        return recruitRepository.getRecruitList()
    }
}