package com.jonathan.hostelbedcart.repository

import android.util.ArrayMap
import com.jonathan.hostelbedcart.model.Exchange
import com.jonathan.hostelbedcart.rest.repository.ExchangeRateImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.stubbing.OngoingStubbing
import org.mockito.Mockito.`when`



class ExchangeRateImplTest {

    val exchange :Exchange =  Exchange("usd", ArrayMap(),"date")
    var exchangeRateImpl : ExchangeRateImpl? = null
    val exchangeRateImplCallback : ExchangeRateImpl.Callback = object : ExchangeRateImpl.Callback{
        override fun onSuccess(exchange: Exchange) {

        }

        override fun onError(message: String) {

        }
    }

    @Before
    fun setUp() {
        exchangeRateImpl = ExchangeRateImpl(exchangeRateImplCallback)
    }

    @Test
    fun getExchangeSuccess() {
        `when`(exchangeRateImplCallback.onSuccess(exchange)).thenReturn(exchange)
        Assert.assertEquals(exchange, exchangeRateImplCallback.onSuccess(exchange))
    }
    @Test
    fun getExchangeError() {
        `when`(exchangeRateImplCallback.onError("")).thenReturn("Simulating error!!")
        Assert.assertEquals(exchange, exchangeRateImplCallback.onSuccess(exchange))
    }
}

private fun <T> OngoingStubbing<T>.thenReturn(s: String): String {
 return "Simulation Error"
}

private fun <T> OngoingStubbing<T>.thenReturn(exchange: Exchange): Exchange {
return exchange
}
