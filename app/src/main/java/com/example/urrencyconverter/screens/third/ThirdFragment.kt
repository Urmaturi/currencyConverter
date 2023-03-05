package com.example.urrencyconverter.screens.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.databinding.FragmentThirdBinding
import com.example.urrencyconverter.model.nal.ValutaItem
import com.example.urrencyconverter.screens.MAIN

class ThirdFragment : Fragment(), ListnearCurrency {
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
            adapter = ThirdFragmentAdapter(this)
            recyclerView.adapter = adapter
            viewModel.getMoney()
            val bundle = Bundle()



            viewModel.valytList.observe(viewLifecycleOwner, { list ->
                list.body()?.let { adapter.setList(it) }
            })

        return binding.root
    }

    override fun onClick(name: String, currency: String) {
        val text =  name + currency
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText( layoutInflater.context, text, duration)
        toast.show()
       // Navigation.findNavController(view)
            //.navigate(R.id.action_rootFragment_to_thirdFragment)
        val bundle = Bundle()
        val bundle2 = Bundle()
        bundle.putString("name", name)
        bundle2.putString("currency",currency)
        MAIN.navController.navigate(R.id.action_thirdFragment_to_secondFragment)

    }


}