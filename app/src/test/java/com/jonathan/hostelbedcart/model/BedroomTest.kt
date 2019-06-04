package com.jonathan.hostelbedcart.model

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class BedroomTest {

    lateinit var bedroom : Bedroom
    @Before
    fun setUp() {
        bedroom = Bedroom(6,7.14F)
    }

    @Test
    fun `validateCalTotalPriceRoom`() {
        assertNotNull(bedroom)
        assertEquals( (6*7.14F) , bedroom.totalPriceRoom())
    }
}