package com.robelseyoum.airvettakehomecoding.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserService
import com.robelseyoum.airvettakehomecoding.utils.Constants.Companion.BASE_URL_RANDOM_USER
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  NetworkModule {

    @Singleton
    @Provides
    fun provideRandomUserService(retrofit: Retrofit.Builder): RandomUserService =
        retrofit.build().create(RandomUserService::class.java)

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor).build()
    }

//    @Singleton
//    @Provides
//    fun provideGsonBuilder(): Gson =
//        GsonBuilder()
//            .registerTypeAdapter(RandomUserService::class.java, ListDeserializer())
//            .create()

    @Singleton
    @Provides
    fun provideRetrofitBuilder(httpClient: OkHttpClient, gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_RANDOM_USER)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
    }

}