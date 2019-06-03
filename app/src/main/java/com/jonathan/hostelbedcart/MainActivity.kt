package com.jonathan.hostelbedcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jonathan.hostelbedcart.rest.api.ExchangeRateAPI
import com.jonathan.hostelbedcart.rest.repository.ExchangeRateImpl

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ExchangeRateImpl().getExchange()
    }
}
