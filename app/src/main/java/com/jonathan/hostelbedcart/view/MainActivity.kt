package com.jonathan.hostelbedcart.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jonathan.hostelbedcart.view.adapter.BedroomAdapter
import com.jonathan.hostelbedcart.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.getViewModel



class MainActivity : AppCompatActivity() {

    lateinit var mainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.jonathan.hostelbedcart.R.layout.activity_main)
        mainActivityViewModel = getViewModel()
        mainActivityViewModel.getExchangeRate()

        val resultObserver = object : Observer<String> {
            override fun onChanged(result: String) {
                tvPriceTotal.text = result
            }
        }

        mainActivityViewModel.getTotalPrice().observe(this, resultObserver)

        rvroom.layoutManager = LinearLayoutManager(this)
        rvroom.adapter = BedroomAdapter(mainActivityViewModel.bedroomList, mainActivityViewModel.priceChangeListener)
    }




}
