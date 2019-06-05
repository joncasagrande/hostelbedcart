package com.jonathan.hostelbedcart.rest

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.io.File

class BaseHttpTest {

    lateinit var baseHttp: BaseHttp
    @Before
    fun setUp() {
        baseHttp = BaseHttp()
    }

    @Test
    fun `getHttpClient$app_debug`() {
        assertNotNull(baseHttp)
        assertNotNull(baseHttp.httpClient)
        assertNotNull(baseHttp.httpClient!!.interceptors())
        assertEquals(60000,baseHttp.httpClient!!.connectTimeoutMillis())
        assertEquals(60000,baseHttp.httpClient!!.readTimeoutMillis())
    }
}