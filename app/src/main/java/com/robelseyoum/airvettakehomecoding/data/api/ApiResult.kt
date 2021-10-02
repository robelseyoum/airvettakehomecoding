package com.robelseyoum.airvettakehomecoding.data.api

sealed class ApiResult <out T> {
    data class Success<out T>(val value: T): ApiResult<T>()
    data class GenericError(val code: Int? = null, val errorMessages: String? = null): ApiResult<Nothing>()
    object NetworkError : ApiResult<Nothing>()
}

enum class RandomUserApiStatus { LOADING, ERROR, DONE }
