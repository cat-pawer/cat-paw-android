package com.catpaw.recruit.usecase

import com.catpaw.recruit.model.RecruitComment
import com.catpaw.recruit.repository.DetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentListUseCase @Inject constructor(
    private val detailRepository: DetailRepository
) {
    operator fun invoke(id: Int): Flow<Result<List<RecruitComment>>> {
        return detailRepository.getCommentList(id)
    }
}