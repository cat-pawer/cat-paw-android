package com.catpaw.recruit.datasource.remote.service

import com.google.common.truth.Truth
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailDataSourceImplTest {
    private lateinit var detailService: DetailService

    private lateinit var server: MockWebServer

    @BeforeEach
    fun setUp() {
//        Mockito.reset(detailService)
        server = MockWebServer()
        server.start()
        detailService = Retrofit.Builder()
            .baseUrl("https://api.my-pooding.com/api/v1/")//Pass any base url like this
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(DetailService::class.java)
    }

    @Test
    @DisplayName("모집 상세 정보 호출 성공(Mock 사용)")
    fun `getDetail Success with mock server`() = runTest {
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(Gson().toJson(detailSuccess))
        server.enqueue(mockResponse)
        val dataSource = DetailDataSourceImpl(detailService)
        val result = dataSource.getDetail(1).first()
        Truth.assertThat(result.isSuccess).isTrue()
        Truth.assertThat(result.getOrThrow().data.id).isEqualTo(detailSuccess.data.id)
        println(result)
    }

    @Test
    @Disabled("실제 서버 테스트")
    fun `getDetail Success with real server`() = runTest {
        val dataSource = DetailDataSourceImpl(detailService)
        val result = dataSource.getDetail(1).first()
        assert(result.isSuccess)
        Truth.assertThat(result.getOrThrow().data.id).isNotNull()
        println(result)
    }

    @AfterEach
    fun afterTest() {
        server.shutdown()
    }
}