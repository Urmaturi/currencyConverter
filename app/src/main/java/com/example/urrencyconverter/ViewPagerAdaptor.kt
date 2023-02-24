package com.example.urrencyconverter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.urrencyconverter.screens.second.SecondFragment
import com.example.urrencyconverter.screens.start.StartFragment
import com.example.urrencyconverter.screens.third.ThirdFragment

class ViewPagerAdaptor(fragmentActivity: FragmentActivity   ): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
         return when(position)
         {
             0 -> StartFragment()
              else ->  SecondFragment()
         }

    }
}