package com.timmitof.photoroulette.data.interceptors

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.lang.Exception
import java.net.SocketException
import java.net.SocketTimeoutException

class NetworkInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable()) {
            throw NoInternetException(message = "No internet connection")
        }
        val request = chain.request()
        try {
            val response = chain.proceed(request)
            if (response.isSuccessful) {
                return chain.proceed(request)
            } else {
                throw ServerException(errorCode = response.code, message = response.message)
            }
        } catch (e: Exception) {
            val response = chain.proceed(request)
            throw ServerException(errorCode = response.code, message = response.message)
        }
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}

class NoInternetException(message: String) : IOException(message)

class ServerException(val errorCode: Int?, message: String?) : IOException(message)