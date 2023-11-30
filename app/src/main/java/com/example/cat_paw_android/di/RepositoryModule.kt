package com.example.cat_paw_android.di

import com.catpaw.recruit.repository.RecruitRepository
import com.catpaw.recruit.repository.RecruitRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    /* 
    구현부가 필요 없을 때는 Binds
    Builder등을 사용해 직접 생성해야 될 때는 Provides -> interface에 사용 불가
     */
    
    @Binds
    @Singleton
    abstract fun bindUnsplashRepository(recruitRepositoryImpl: RecruitRepositoryImpl): RecruitRepository
}