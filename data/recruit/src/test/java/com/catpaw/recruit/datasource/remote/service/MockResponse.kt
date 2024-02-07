package com.catpaw.recruit.datasource.remote.service

import com.catpaw.recruit.dto.response.CatPawResponse
import com.catpaw.recruit.dto.response.CategoryResponse
import com.catpaw.recruit.dto.response.RecruitDetailResponse
import java.text.SimpleDateFormat
import java.util.Date

private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSS")
private val currentDate = dateFormat.format(Date())
internal val detailSuccess: CatPawResponse<RecruitDetailResponse> = CatPawResponse(
    0, "메시지", RecruitDetailResponse(
        id = 1,
        title = "title0",
        content = "asdasd",
        contact = "0102323",
        groupType = "PROJECT",
        recruitPeriod = "2023-12-08",
        peopleNumber = 3,
        expectDuration = 1,
        viewCount = 0,
        commentCount = 0,
        onlineType = "ONLINE",
        state = "ACTIVE",
        created = currentDate,
        updated = currentDate,
        createdBy = 0,
        updatedBy = 0,
        tagList = listOf(
            CategoryResponse(0, 11, "타입", "00-00-00", "HASH", 0, "타겟 타입", currentDate),
            CategoryResponse(0, 12, "타입", "00-00-00", "HASH", 1, "타겟 타입", currentDate),
            CategoryResponse(0, 13, "타입", "00-00-00", "HASH", 2, "타겟 타입", currentDate)
        ),
        positionList = emptyList(),
        techList = listOf(
            CategoryResponse(0, 1, "타입", "00-00-00", "TECH_STACK", 0, "img", currentDate),
            CategoryResponse(0, 2, "타입", "00-00-00", "TECH_STACK", 1, "img", currentDate),
            CategoryResponse(0, 3, "타입", "00-00-00", "TECH_STACK", 2, "img", currentDate)
        )
    )
)