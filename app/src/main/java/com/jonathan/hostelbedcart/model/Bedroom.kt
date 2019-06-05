package com.jonathan.hostelbedcart.model

data class Bedroom(val name: String, val description: String, val beds : Int, val priceBed: Float, var selectedBed: Int = 0){

    var bookedBeds: Int = 0
        set(value){
            if (value in 1..beds){
            field = value
            }
        }

    init {
        bookedBeds = selectedBed
    }
    fun totalPriceRoom(): Float = (priceBed * beds)

    fun calculatePrice():Float = (bookedBeds * priceBed)
}