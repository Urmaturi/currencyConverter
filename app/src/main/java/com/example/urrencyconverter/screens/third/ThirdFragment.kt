package com.example.urrencyconverter.screens.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.databinding.FragmentThirdBinding
import com.example.urrencyconverter.screens.start.StartAdapter

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ThirdFragmentAdapter

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val v = inflater.inflate(R.layout.fragment_start, container, false)
            binding = FragmentThirdBinding.inflate( layoutInflater, container, false)
            val viewModel = ViewModelProvider(this)[ThirdViewModel::class.java]
            recyclerView = binding.rvSimple
            adapter = ThirdFragmentAdapter()
            recyclerView.adapter = adapter
            viewModel.getMoney()

            viewModel.valytList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setList(it) }
            })

        return binding.root
    }


}