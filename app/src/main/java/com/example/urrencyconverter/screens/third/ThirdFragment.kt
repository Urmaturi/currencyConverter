package com.example.urrencyconverter.screens.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.urrencyconverter.R
import com.example.urrencyconverter.databinding.FragmentSecondBinding
import com.example.urrencyconverter.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

            binding = FragmentThirdBinding.inflate( layoutInflater, container, false)


        return binding.root
    }
}