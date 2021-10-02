package com.robelseyoum.airvettakehomecoding.data.api

import com.robelseyoum.airvettakehomecoding.data.model.RandomUser
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserService {
    @GET("api/")
    suspend fun getRandomUser(
        @Query("results") results: Int = 30
    ): RandomUser
}