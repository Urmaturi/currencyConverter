package com.example.urrencyconverter.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.model.nal.Valuta
import kotlinx.android.synthetic.main.item_money_layout.view.*

class StartAdapter:RecyclerView.Adapter<StartAdapter.StartViewHolder>() {

     var listStart = emptyList<Valuta>()

    class StartViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout,parent,false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.item_name.text = listStart[position].Name
        holder.itemView.item_buy.text = listStart[position].Value
        holder.itemView.item_sale.text = listStart[position].Previous
    }

    override fun getItemCount(): Int {
       return listStart.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Valuta>)
    {
        listStart = list
        notifyDataSetChanged()
    }

}