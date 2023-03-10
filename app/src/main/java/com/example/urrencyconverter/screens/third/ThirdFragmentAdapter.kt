package com.example.urrencyconverter.screens.third

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.model.nal.AllJsonData
import com.example.urrencyconverter.model.nal.ValutaItem
import kotlinx.android.synthetic.main.fragment_item_currency.view.*
import kotlinx.android.synthetic.main.item_money_layout.view.*


class ThirdFragmentAdapter(val listener: ListnearCurrency) :
    RecyclerView.Adapter<ThirdFragmentAdapter.TherdFrgViewHolder>() {

    var listStart = emptyList<AllJsonData>()
    var tempList = ArrayList<ValutaItem>()

    class TherdFrgViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TherdFrgViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_currency, parent, false)
        return TherdFrgViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tempList.size
    }

    override fun onBindViewHolder(holder: TherdFrgViewHolder, position: Int) {

        holder.itemView.itemValutName.text = tempList[position].name
        holder.itemView.itemValutCurrency.text = tempList[position].previews

        holder.itemView.rowLin.setOnClickListener {
            listener.onClick(tempList[position].previews, tempList[position].Value,tempList[position].Nominal)
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: AllJsonData) {
        listStart = listOf(list)


        tempList.add(
            ValutaItem(
                listStart[0].Valute.AED.Name,
                listStart[0].Valute.AED.CharCode,
                listStart[0].Valute.AED.Value.toString(),
                listStart[0].Valute.AED.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.AMD.Name,
                listStart[0].Valute.AMD.CharCode,
                listStart[0].Valute.AMD.Value.toString(),
                listStart[0].Valute.AMD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.AUD.Name,
                listStart[0].Valute.AUD.CharCode,
                listStart[0].Valute.AUD.Value.toString(),
                listStart[0].Valute.AUD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.AZN.Name,
                listStart[0].Valute.AZN.CharCode,
                listStart[0].Valute.AZN.Value.toString(),
                listStart[0].Valute.AZN.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.BGN.Name,
                listStart[0].Valute.BGN.CharCode,
                listStart[0].Valute.BGN.Value.toString(),
                listStart[0].Valute.BGN.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.BRL.Name,
                listStart[0].Valute.BRL.CharCode,
                listStart[0].Valute.BRL.Value.toString(),
                listStart[0].Valute.BRL.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.BYN.Name,
                listStart[0].Valute.BYN.CharCode,
                listStart[0].Valute.BYN.Value.toString(),
                listStart[0].Valute.BYN.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CAD.Name,
                listStart[0].Valute.CAD.CharCode,
                listStart[0].Valute.CAD.Value.toString(),
                listStart[0].Valute.CAD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CHF.Name,
                listStart[0].Valute.CHF.CharCode,
                listStart[0].Valute.CHF.Value.toString(),
                listStart[0].Valute.CHF.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CNY.Name,
                listStart[0].Valute.CNY.CharCode,
                listStart[0].Valute.CNY.Value.toString(),
                listStart[0].Valute.CNY.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.CZK.Name,
                listStart[0].Valute.CZK.CharCode,
                listStart[0].Valute.CZK.Value.toString(),
                listStart[0].Valute.CZK.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.EUR.Name,
                listStart[0].Valute.EUR.CharCode,
                listStart[0].Valute.EUR.Value.toString(),
                listStart[0].Valute.EUR.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.USD.Name,
                listStart[0].Valute.USD.CharCode,
                listStart[0].Valute.USD.Value.toString(),
                listStart[0].Valute.USD.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.KGS.Name,
                listStart[0].Valute.KGS.CharCode,
                listStart[0].Valute.KGS.Value.toString(),
                listStart[0].Valute.KGS.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.KZT.Name,
                listStart[0].Valute.KZT.CharCode,
                listStart[0].Valute.KZT.Value.toString(),
                listStart[0].Valute.KZT.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.UZS.Name,
                listStart[0].Valute.UZS.CharCode,
                listStart[0].Valute.UZS.Value.toString(),
                listStart[0].Valute.UZS.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.TJS.Name,
                listStart[0].Valute.TJS.CharCode,
                listStart[0].Valute.TJS.Value.toString(),
                listStart[0].Valute.TJS.Nominal
            )
        )
        tempList.add(
            ValutaItem(
                listStart[0].Valute.GBP.Name,
                listStart[0].Valute.GBP.CharCode,
                listStart[0].Valute.GBP.Value.toString(),
                listStart[0].Valute.GBP.Nominal
            )
        )

        notifyDataSetChanged()
    }

}


