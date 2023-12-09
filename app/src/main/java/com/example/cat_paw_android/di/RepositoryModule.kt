package com.example.cat_paw_android.di

import com.catpaw.recruit.datasource.remote.DetailDataSource
import com.catpaw.recruit.datasource.remote.DetailDataSourceImpl
import com.catpaw.recruit.repository.DetailRepository
import com.catpaw.recruit.repository.DetailRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    /* 
    구현부가 필요 없을 때는 Binds
    Builder등을 사용해 직접 생성해야 될 때는 Provides -> interface에 사용 불가
     */

//    @Binds
//    @Singleton
//    fun bindRecruitRepository(recruitRepositoryImpl: RecruitRepositoryImpl): RecruitRepository

    @Binds
    @Singleton
    abstract fun bindsRecruitDetailRepository(detailDRepository: DetailRepositoryImpl): DetailRepository
}