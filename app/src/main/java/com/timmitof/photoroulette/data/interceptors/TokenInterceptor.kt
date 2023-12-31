package com.timmitof.photoroulette.data.interceptors

import com.timmitof.photoroulette.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder().apply {
            header("Authorization", BuildConfig.API_KEY)
        }
        return chain.proceed(newRequest.build())
    }
}