package com.robelseyoum.airvettakehomecoding.data.api

import com.robelseyoum.airvettakehomecoding.data.model.RandomUserBase
import retrofit2.http.GET

interface RandomUserService {
    @GET("?results=10")
    suspend fun getRandomUser(): RandomUserBase
}