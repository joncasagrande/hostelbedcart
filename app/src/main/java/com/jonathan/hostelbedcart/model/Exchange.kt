package com.jonathan.hostelbedcart.model

import java.util.*

data class Exchange(val base: String, val rates : List<Rates>,val date: String) {

    fun convetChange(from: Currency, to: Currency): Float{
        return 0f
    }


    private fun getRateCurreny(currency: Currency):Rates{
        return rates.filter{ it.locale == currency.currencyCode }[0]

    }
}