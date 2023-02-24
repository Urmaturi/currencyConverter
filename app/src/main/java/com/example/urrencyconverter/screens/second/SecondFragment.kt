package com.example.urrencyconverter.screens.second

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.urrencyconverter.R
import com.example.urrencyconverter.databinding.FragmentSecondBinding
import com.example.urrencyconverter.screens.MAIN
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {


    private lateinit var viewModels: ViewModel
    lateinit var dialog: Dialog
    lateinit var binding: FragmentSecondBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       binding = FragmentSecondBinding.inflate(layoutInflater,container,false)

        //val view = inflater.inflate(R.layout.fragment_second, container, false)
        dialog = Dialog(requireContext())


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.nextChange.setOnClickListener {
          //  MAIN.navController.navigate(R.id.action_secondFragment_to_thirdFragment)
            Navigation.findNavController(view)
                .navigate(R.id.action_rootFragment_to_thirdFragment)

        }
        binding.root.nextChange2.setOnClickListener {
            MAIN.navController.navigate(R.id.action_rootFragment_to_thirdFragment)
        }
        binding.root.txtNumCur1.setOnClickListener {
            dialogCurrentChange()
        }
        binding.root.txtNumCur2.setOnClickListener {
            dialogCurrentChange2()
        }

    }


    private fun dialogCurrentChange2() {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.fragment_chanege_cash)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<Button>(R.id.dialog_save)
        val exit = dialog.findViewById<ImageView>(R.id.imgCancel)
        val textCurrency = dialog.findViewById<EditText>(R.id.edt_currency)
        buttonYES.setOnClickListener {
            view?.txtNumCur2?.text = textCurrency.text
           // converterInfo2(textCurrency.text.toString())
            dialog.dismiss()
        }
        exit.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
    fun dialogCurrentChange() {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.fragment_chanege_cash)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<Button>(R.id.dialog_save)
        val exit = dialog.findViewById<ImageView>(R.id.imgCancel)
        val textCurrency = dialog.findViewById<EditText>(R.id.edt_currency)
        buttonYES.setOnClickListener {
            view?.txtNumCur1?.text = textCurrency.text
            //  converterInfo(textCurrency.text.toString())
            dialog.dismiss()
        }
        exit.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
    fun dilig(view: View) {}


}