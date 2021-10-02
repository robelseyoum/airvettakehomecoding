package com.robelseyoum.airvettakehomecoding.utils

import com.robelseyoum.airvettakehomecoding.data.api.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

suspend fun <T> safeApi(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T? //It takes a function as input and in order to execute the function you have to call cacheCall.invoke() on it
): ApiResult<T?> {

    return withContext(dispatcher) {
        try {
//            throws TimeoutCancellationException
            ApiResult.Success(apiCall.invoke()) //if it is success then it will pass the return type of the suspend function T (type of T) this -(apiCall: suspend () -> T? )
        }
        catch (throwable: Throwable) {

            throwable.printStackTrace()

            when (throwable) {

                is TimeoutCancellationException -> {
                    val code = 408 //timeout error code
                    ApiResult.GenericError(code, Constants.NETWORK_ERROR_TIMEOUT)
                }

                is IOException -> {
                    ApiResult.NetworkError
                }

                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse =
                        convertErrorBody(
                            throwable
                        )
                    ApiResult.GenericError(
                        code,
                        errorResponse
                    )
                }

                else -> {
                    ApiResult.GenericError(
                        null,
                        Constants.NETWORK_ERROR_UNKNOWN
                    )
                }
            }
        }
    }
}

fun convertErrorBody(throwable: HttpException): String? {
    return try {
        throwable.response()?.errorBody()?.string()
    } catch (exception: Exception) {
        Constants.ERROR_UNKNOWN
    }
}
