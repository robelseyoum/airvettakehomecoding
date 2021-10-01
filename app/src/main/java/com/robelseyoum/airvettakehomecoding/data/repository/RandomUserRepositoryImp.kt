package com.robelseyoum.airvettakehomecoding.data.repository

import com.robelseyoum.airvettakehomecoding.data.api.ApiResult
import com.robelseyoum.airvettakehomecoding.data.model.RandomUserBase

interface RandomUserRepositoryImp {
    suspend fun getRandomUser(): ApiResult<RandomUserBase>
}