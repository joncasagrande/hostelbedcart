package com.jonathan.hostelbedcart.model

import android.util.ArrayMap
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class ExchangeTest {

    lateinit var exchange: Exchange
    val  USD : String = "USD"
    val  BRL : String = "BRL"
    @Before
    fun setUp() {
        val arrayMap : ArrayMap<String,Float>  = ArrayMap()
        arrayMap.put(USD, 1.40F)
        arrayMap.put(BRL, 4.00F)
        exchange = Exchange("EUR",arrayMap,"any random date")
    }

    @Test
    fun deserialize() {
    }

    @Test
    fun calculatePriceInCurrency() {
        val floatValue : Float = 1F
        assertNotNull(exchange)
        assertEquals(1.40F, exchange.calculatePriceInCurrency(USD,floatValue))
        assertEquals(4.00F, exchange.calculatePriceInCurrency(BRL,floatValue))
    }

    @Test
    fun calculatePriceInUSD() {
        val floatValue : Float = 1F
        assertNotNull(exchange)
        assertEquals(1.40F, exchange.calculatePriceInUSD(floatValue))
    }

    @Test
    fun calculateInUnexistantCurrenct(){
        val floatValue : Float = 1F
        assertNotNull(exchange)
        assertEquals(-1F, exchange.calculatePriceInCurrency("",floatValue))

    }
}