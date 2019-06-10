package com.jonathan.hostelbedcart.model

data class Bedroom(val name: String, val description: String, val beds : Int, val priceBed: Float){

    var bookedBeds: Int = 0
        set(value){
            if (value in 0..beds){
            field = value
            }
        }

    fun totalPriceRoom(): Float = (priceBed * beds)

    fun calculatePricePerBookedBeds():Float = (bookedBeds * priceBed)
}