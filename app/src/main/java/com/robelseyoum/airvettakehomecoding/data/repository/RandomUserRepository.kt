package com.robelseyoum.airvettakehomecoding.data.repository

import com.robelseyoum.airvettakehomecoding.concurrency.AppDispatchers
import com.robelseyoum.airvettakehomecoding.data.api.ApiResult
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserService
import com.robelseyoum.airvettakehomecoding.data.model.RandomUser
import com.robelseyoum.airvettakehomecoding.utils.safeApi

class RandomUserRepository(
    private val randomUserService: RandomUserService,
    private val appDispatchers: AppDispatchers
): RandomUserRepositoryImp {
    override suspend fun getRandomUser(): ApiResult<RandomUser?> =
        safeApi(appDispatchers.io) { randomUserService.getRandomUser() }
}