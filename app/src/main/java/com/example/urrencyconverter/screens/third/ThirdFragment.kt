package com.example.urrencyconverter.screens.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.databinding.FragmentThirdBinding


class ThirdFragment : Fragment(), ListnearCurrency {
    lateinit var binding: FragmentThirdBinding

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ThirdFragmentAdapter
    val bundle = Bundle()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_start, container, false)
        binding = FragmentThirdBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProvider(this)[ThirdViewModel::class.java]
        recyclerView = binding.rvSimple
        adapter = ThirdFragmentAdapter(this)
        recyclerView.adapter = adapter
        viewModel.getMoney()




        viewModel.valytList.observe(viewLifecycleOwner, { list ->
            list.body()?.let { adapter.setList(it) }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(name: String, currency: String, nominal : Int) {
//        val text = name + currency
//        val duration = Toast.LENGTH_SHORT
//
//        val toast = Toast.makeText(layoutInflater.context, text, duration)
//        toast.show()


        val curranceA = arguments?.getString("CurranceA")
        val nameA = arguments?.getString("NameA")
        val nominalA = arguments?.getInt("nominalA")

        val curranceB = arguments?.getString("CurranceB")
        val nameB = arguments?.getString("NameB")
        val nominalB = arguments?.getInt("nominalB")

        val flag = arguments?.getBoolean("flag") == false
        val flagVyborValyt = arguments?.getBoolean("flag2")== true



        bundle.putString("currency", currency)
        bundle.putString("name", name)
        bundle.putInt("nominal",nominal)

        bundle.putBoolean("flag",flag)
        bundle.putBoolean("flag2",flagVyborValyt)

        if (flagVyborValyt == true) {
            bundle.putString("currencyOld", curranceA)
            bundle.putString("nameOld", nameA)
            bundle.putInt("nominalOld",nominalA!!)
        } else {
            bundle.putString("currencyOld", curranceB)
            bundle.putString("nameOld", nameB)
            bundle.putInt("nominalOld",nominalB!!)
        }


        findNavController().navigate(R.id.action_thirdFragment_to_secondFragment, bundle)


    }


}