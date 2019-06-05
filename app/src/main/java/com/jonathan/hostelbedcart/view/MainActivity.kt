package com.jonathan.hostelbedcart.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jonathan.hostelbedcart.R
import com.jonathan.hostelbedcart.viewmodel.MainActivityViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = getViewModel()
        mainActivityViewModel.getExchangeRate()
    }
}
