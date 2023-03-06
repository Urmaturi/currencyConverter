package com.example.urrencyconverter.screens.start

import android.content.Context
import android.os.Bundle
import android.view.GestureDetector
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.urrencyconverter.R
import com.example.urrencyconverter.ViewPagerAdaptor
import kotlinx.android.synthetic.main.fragment_root.view.*
import kotlinx.android.synthetic.main.fragment_start.view.*
import com.example.urrencyconverter.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StartAdapter
    lateinit var binding:  FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        binding = FragmentStartBinding.inflate(layoutInflater,container,false)
        //val v = inflater.inflate(R.layout.fragment_start, container, false)


        recyclerView = binding.rvStart // v.rv_start
        adapter = StartAdapter()
        recyclerView.adapter = adapter

        viewModel.getMoney()
        viewModel.valytList.observe(viewLifecycleOwner, { list ->
            list.body()?.let { adapter.setList(it) }
        })





        return binding.root
        //return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                binding.btnName.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_startFragment_to_secondFragment)
        }


        super.onViewCreated(view, savedInstanceState)
    }

}
