package com.example.urrencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.urrencyconverter.databinding.ActivityMainBinding
import com.example.urrencyconverter.screens.MAIN

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
     lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this,R.id.nav_host)
        MAIN = this


    }
}