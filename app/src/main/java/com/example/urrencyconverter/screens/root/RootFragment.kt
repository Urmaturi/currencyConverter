package com.example.urrencyconverter.screens.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.urrencyconverter.R
import com.example.urrencyconverter.ViewPagerAdaptor
import kotlinx.android.synthetic.main.fragment_root.view.*

class RootFragment : Fragment() {

    private var cntxt: Context?= null

     override fun onAttach(context: Context) {
         super.onAttach(context)
         cntxt = context
     }


     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {

         val view = inflater.inflate(R.layout.fragment_root,container,false)
         view.viewPager.adapter = ViewPagerAdaptor(cntxt as FragmentActivity)
         return view
     }




}