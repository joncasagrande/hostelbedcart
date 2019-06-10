package com.jonathan.hostelbedcart.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonathan.hostelbedcart.R
import com.jonathan.hostelbedcart.model.Bedroom
import com.jonathan.hostelbedcart.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.row_item.view.*

class BedroomAdapter(val data: List<Bedroom>, val priceChangeListener: MainActivityViewModel.PriceChangeListener) : RecyclerView.Adapter<BedroomAdapter.BedroomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BedroomViewHolder {
        return BedroomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BedroomViewHolder, position: Int) = holder.bind(data[position])


    inner class BedroomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Bedroom) = with(itemView) {
            tvBedroom.text = item.name

            btnAdd.setOnClickListener{
                if(item.bookedBeds <= item.beds){
                    item.bookedBeds++
                    tvBed.text = item.bookedBeds.toString()
                    this@BedroomAdapter.priceChangeListener.udpatePrice()
                }
            }

            btnRemove.setOnClickListener{
                if(item.bookedBeds >= 0){
                    item.bookedBeds--
                    tvBed.text = item.bookedBeds.toString()
                    this@BedroomAdapter.priceChangeListener.udpatePrice()
                }
            }

            setOnClickListener {

            }
        }
    }
}