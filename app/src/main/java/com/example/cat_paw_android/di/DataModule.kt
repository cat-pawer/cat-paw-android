package com.example.cat_paw_android.di

import com.catpaw.recruit.datasource.remote.DetailDataSource
import com.catpaw.recruit.datasource.remote.DetailDataSourceImpl
import com.catpaw.recruit.datasource.remote.SummaryLocalDataSource
import com.catpaw.recruit.datasource.remote.SummaryLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindsRecruitDetailDataSource(detailDataSourceImpl: DetailDataSourceImpl): DetailDataSource

    @Binds
    @Singleton
    abstract fun bindsRecruitSummaryDataSource(summaryDataSourceImpl: SummaryLocalDataSourceImpl): SummaryLocalDataSource
}