package com.jonathan.hostelbedcart.rest.repository

import android.util.Log
import com.jonathan.hostelbedcart.model.Exchange
import com.jonathan.hostelbedcart.rest.BaseAPI
import com.jonathan.hostelbedcart.rest.api.ExchangeRateAPI
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.inject

class ExchangeRateImpl(val callback: Callback) : KoinComponent {
    val baseAPI : BaseAPI by inject()
    private val exchangeRateAPI: ExchangeRateAPI = baseAPI.createService(ExchangeRateAPI::class.java)

    interface Callback {
        fun onSuccess(exchange: Exchange)
        fun onError(message: String)
    }


    fun getExchange() {
        val postLogin = exchangeRateAPI.getCurrency("USD")
        postLogin.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Exchange> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onSuccess(exchange: Exchange) {
                    Log.d(ExchangeRateAPI::class.simpleName, "Success called")
                    callback.onSuccess(exchange)
                }

                override fun onError(throwable: Throwable) {
                    Log.d(ExchangeRateAPI::class.simpleName, "Error calling address API.", throwable)
                    callback.onError(BaseAPI.getErrorMessage(throwable))
                }
            })
    }

}