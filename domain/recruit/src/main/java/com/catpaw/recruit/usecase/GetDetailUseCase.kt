package com.catpaw.recruit.usecase

import com.catpaw.recruit.model.RecruitDetail
import com.catpaw.recruit.repository.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(
    private val detailRepository: DetailRepository,
) {
    operator fun invoke(id: Int): Flow<Result<RecruitDetail>> = detailRepository.getDetail(id)
}