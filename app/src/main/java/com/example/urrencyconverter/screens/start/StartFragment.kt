package com.example.urrencyconverter.screens.start

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.ViewPagerAdaptor
import kotlinx.android.synthetic.main.fragment_root.view.*
import kotlinx.android.synthetic.main.fragment_start.view.*


class StartFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        val v = inflater.inflate(R.layout.fragment_start, container, false)
        recyclerView = v.rv_start
        adapter = StartAdapter()
        recyclerView.adapter = adapter

        viewModel.getMoney()
        viewModel.valytList.observe(viewLifecycleOwner, { list ->
            list.body()?.let { adapter.setList(it) }
        })

        //val view = inflater.inflate(R.layout.fragment_start,container,false)
       // v.viewPager.adapter = ViewPagerAdaptor(cntxt as FragmentActivity)
        //return view


        return v
    }

}
