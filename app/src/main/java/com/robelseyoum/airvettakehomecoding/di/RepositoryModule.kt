package com.robelseyoum.airvettakehomecoding.di

import com.robelseyoum.airvettakehomecoding.concurrency.AppDispatchers
import com.robelseyoum.airvettakehomecoding.concurrency.AppDispatchersImpl
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserService
import com.robelseyoum.airvettakehomecoding.data.repository.RandomUserRepository
import com.robelseyoum.airvettakehomecoding.data.repository.RandomUserRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAppDispatchers(): AppDispatchers {
        return AppDispatchersImpl()
    }

    @Singleton
    @Provides
    fun provideMainRepository(
        statusService: RandomUserService,
        appDispatchers: AppDispatchers
    ) : RandomUserRepositoryImp = RandomUserRepository(statusService, appDispatchers)

}