package com.jonathan.hostelbedcart.rest

import com.jonathan.hostelbedcart.BaseApplication
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class BaseHttp {

    @get:Provides
    @get:Singleton
    internal var httpClient: OkHttpClient? = null
        private set

    private val logginInterceptor: HttpLoggingInterceptor
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return loggingInterceptor
        }

    init {
        if (httpClient == null)
            httpClient = createHttpClient()
    }

    private fun createHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient().newBuilder()
        httpClientBuilder.connectTimeout(60L, TimeUnit.SECONDS)
        httpClientBuilder.readTimeout(60L, TimeUnit.SECONDS)
        httpClientBuilder.addInterceptor(logginInterceptor)
        httpClientBuilder.cache(createCache())
        return httpClientBuilder.build()
    }

    private fun createCache(): Cache {
        val size = 10 * 1024 * 1024//10mb
        return Cache(BaseApplication.instance!!.cacheDir, size.toLong())
    }

}
