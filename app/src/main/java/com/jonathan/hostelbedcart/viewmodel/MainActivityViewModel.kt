package com.jonathan.hostelbedcart.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jonathan.hostelbedcart.model.Exchange
import com.jonathan.hostelbedcart.rest.repository.ExchangeRateImpl
import com.jonathan.hostelbedcart.rest.api.ExchangeRateAPI

class MainActivityViewModel :ViewModel(){

    var dollarCurrency : Float = 1.0F



    fun getExchangeRate(){
        ExchangeRateImpl(object :
            ExchangeRateImpl.Callback {
            override fun onSuccess(exchange: Exchange) {
                Log.d(ExchangeRateAPI::class.simpleName, "Success called")
            }

            override fun onError(message: String) {
                Log.d(ExchangeRateAPI::class.simpleName, "ERROR called")
            }
        }).getExchange()
    }
}