package com.jonathan.hostelbedcart.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class BedroomTest {

    lateinit var bedroom : Bedroom
    @Before
    fun setUp() {
        bedroom = Bedroom("TestBedroom","Room for teste",6,7.14F)
    }

    @Test
    fun `validateCalTotalPriceRoom`() {
        assertNotNull(bedroom)
        assertEquals( (6*7.14F) , bedroom.totalPriceRoom())
    }
    @Test
    fun `validateCalPricePerSelectedBeds`(){
        assertNotNull(bedroom)
        bedroom.bookedBeds = 4;
        assertEquals( (4*7.14F) , bedroom.calculatePricePerBookedBeds())
    }
}