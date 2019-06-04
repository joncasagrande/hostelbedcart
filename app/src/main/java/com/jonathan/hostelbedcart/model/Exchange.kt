package com.jonathan.hostelbedcart.model

import android.util.ArrayMap
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import java.lang.reflect.Type

data class Exchange(@SerializedName("base") val base: String,
                    @SerializedName("rates") val rates : ArrayMap<String, Float>,
                    @SerializedName("date") val date: String) : JsonDeserializer<Exchange> {


    override fun deserialize(jElement: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Exchange {
        val jObject = jElement!!.getAsJsonObject()
        val base = jObject.get("base").asString
        val date = jObject.get("date").getAsString()
        val ratesValues = jObject.get("rates").getAsString()
        val rates = ratesValues.split(",").associate {
            val (left, right) = it.split(":")
            left to right.toFloat()
        }
        return Exchange(base,rates as ArrayMap<String, Float>,date)
    }

    fun calculatePriceInCurrency(currency: String, value: Float):Float {
        if(rates[currency] == null) return -1F
        return value * rates[currency]!!
    }

    fun calculatePriceInUSD(value : Float):Float{
        return calculatePriceInCurrency("USD",value)
    }

}