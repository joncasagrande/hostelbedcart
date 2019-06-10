package com.jonathan.hostelbedcart.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonathan.hostelbedcart.model.Bedroom
import com.jonathan.hostelbedcart.model.Exchange
import com.jonathan.hostelbedcart.rest.api.ExchangeRateAPI
import com.jonathan.hostelbedcart.rest.repository.ExchangeRateImpl
import java.text.DecimalFormat

class MainActivityViewModel :ViewModel(){

    public interface PriceChangeListener{
        fun udpatePrice()
    }

    var exchange: Exchange? = null
    var dollarCurrency : Float = 1.0F
    lateinit var bedroomList: List<Bedroom>

    val totalLiveData : MutableLiveData<String> = MutableLiveData()

    val priceChangeListener : PriceChangeListener = object : PriceChangeListener{
        override fun udpatePrice() {
            getTotalPrice()
        }
    }
    init {
        createBedrooms()
    }

    private fun createBedrooms():List<Bedroom>{
        bedroomList = listOf(
            Bedroom("Bedroom 1","",6,17.56F),
            Bedroom("Bedroom 2","",8,14.50F),
            Bedroom("Bedroom 3","",12,12.01F)
        )
        return bedroomList
    }

    fun getTotalPrice():MutableLiveData<String>{
        var totalPrice: Float = 0F
        bedroomList.forEach { totalPrice = totalPrice + it.calculatePricePerBookedBeds() }
        val decimal = DecimalFormat("#.##")

        totalLiveData.value  = decimal.format(calculatetotalPriceInDollar(totalPrice).toLong())
        return totalLiveData
    }

    private fun calculatetotalPriceInDollar(totalPrice: Float): Float{
        if(exchange != null){
            return exchange!!.calculatePriceInUSD(totalPrice)
        }else{
            return (dollarCurrency * totalPrice)
        }
    }


    fun getExchangeRate(){

        ExchangeRateImpl(object :
            ExchangeRateImpl.Callback {
            override fun onSuccess(exchange: Exchange) {
                Log.d(ExchangeRateAPI::class.simpleName, "Success called")
                this@MainActivityViewModel.exchange = exchange
            }

            override fun onError(message: String) {
                Log.d(ExchangeRateAPI::class.simpleName, "ERROR called")
            }
        }).getExchange()
    }
}