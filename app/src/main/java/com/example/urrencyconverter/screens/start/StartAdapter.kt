package com.example.urrencyconverter.screens.start

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.model.nal.AllJsonData
import com.example.urrencyconverter.model.nal.ValutaItem
import kotlinx.android.synthetic.main.item_money_layout.view.*

class StartAdapter : RecyclerView.Adapter<StartAdapter.StartViewHolder>() {

    var listStart = emptyList<AllJsonData>()
    var tempList = ArrayList<ValutaItem>()

    class StartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_money_layout, parent, false)
        return StartViewHolder(view)
    }

    override fun onBindViewHolder(holder: StartViewHolder, position: Int) {
        holder.itemView.item_name.text = tempList[position].name
        holder.itemView.item_buy.text = tempList[position].Value
        holder.itemView.item_sale.text = tempList[position].previews
    }

    override fun getItemCount(): Int {
        return tempList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: AllJsonData) {
        listStart = listOf(list)
        tempList.add(
            ValutaItem(
                listStart[0].Valute.AED.Name,
                listStart[0].Valute.AED.Previous.toString(),
                listStart[0].Valute.AED.Value.toString(),
                listStart[0].Valute.AED.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.AMD.Name,
                listStart[0].Valute.AMD.Previous.toString(),
                listStart[0].Valute.AMD.Value.toString(),
                listStart[0].Valute.AMD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.AUD.Name,
                listStart[0].Valute.AUD.Previous.toString(),
                listStart[0].Valute.AUD.Value.toString(),
                listStart[0].Valute.AUD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.AZN.Name,
                listStart[0].Valute.AZN.Previous.toString(),
                listStart[0].Valute.AZN.Value.toString(),
                listStart[0].Valute.AZN.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.BGN.Name,
                listStart[0].Valute.BGN.Previous.toString(),
                listStart[0].Valute.BGN.Value.toString(),
                listStart[0].Valute.BGN.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.BRL.Name,
                listStart[0].Valute.BRL.Previous.toString(),
                listStart[0].Valute.BRL.Value.toString(),
                listStart[0].Valute.BRL.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.BYN.Name,
                listStart[0].Valute.BYN.Previous.toString(),
                listStart[0].Valute.BYN.Value.toString(),
                listStart[0].Valute.BYN.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CAD.Name,
                listStart[0].Valute.CAD.Previous.toString(),
                listStart[0].Valute.CAD.Value.toString(),
                listStart[0].Valute.CAD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CHF.Name,
                listStart[0].Valute.CHF.Previous.toString(),
                listStart[0].Valute.CHF.Value.toString(),
                listStart[0].Valute.CHF.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CNY.Name,
                listStart[0].Valute.CNY.Previous.toString(),
                listStart[0].Valute.CNY.Value.toString(),
                listStart[0].Valute.CNY.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CZK.Name,
                listStart[0].Valute.CZK.Previous.toString(),
                listStart[0].Valute.CZK.Value.toString(),
                listStart[0].Valute.CZK.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.EUR.Name,
                listStart[0].Valute.EUR.Previous.toString(),
                listStart[0].Valute.EUR.Value.toString(),
                listStart[0].Valute.EUR.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.USD.Name,
                listStart[0].Valute.USD.Previous.toString(),
                listStart[0].Valute.USD.Value.toString(),
                listStart[0].Valute.USD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.KGS.Name,
                listStart[0].Valute.KGS.Previous.toString(),
                listStart[0].Valute.KGS.Value.toString(),
                listStart[0].Valute.KGS.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.KZT.Name,
                listStart[0].Valute.KZT.Previous.toString(),
                listStart[0].Valute.KZT.Value.toString(),
                listStart[0].Valute.KZT.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.UZS.Name,
                listStart[0].Valute.UZS.Previous.toString(),
                listStart[0].Valute.UZS.Value.toString(),
                listStart[0].Valute.UZS.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.TJS.Name,
                listStart[0].Valute.TJS.Previous.toString(),
                listStart[0].Valute.TJS.Value.toString(),
                listStart[0].Valute.TJS.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.GBP.Name,
                listStart[0].Valute.GBP.Previous.toString(),
                listStart[0].Valute.GBP.Value.toString(),
                listStart[0].Valute.GBP.Nominal
            )
        )
        notifyDataSetChanged()
    }


}