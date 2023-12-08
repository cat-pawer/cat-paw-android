package com.example.cat_paw_android.di

import com.catpaw.recruit.datasource.remote.service.DetailDataSourceImpl
import com.catpaw.recruit.repository.RecruitRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindsRecruitDetailDataSource(recruitRepository: RecruitRepository): DetailDataSourceImpl
}