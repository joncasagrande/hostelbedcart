package com.jonathan.hostelbedcart.rest.api

import com.jonathan.hostelbedcart.model.Exchange
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ExchangeRateAPI {

    @GET("latest?symbols={currency}")
    @Headers("Content-type: application/json")
    fun getCurrency(@Query("symbols") currency: String): Single<Exchange>
}