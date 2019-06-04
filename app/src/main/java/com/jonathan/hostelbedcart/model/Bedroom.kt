package com.jonathan.hostelbedcart.model

data class Bedroom(val beds : Int, val priceBed: Float){

    fun totalPriceRoom(): Float = (priceBed * beds)

    fun calculatePrice(numberOfBeds : Int):Float = (numberOfBeds * priceBed)
}