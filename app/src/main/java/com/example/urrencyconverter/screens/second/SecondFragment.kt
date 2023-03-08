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
import androidx.navigation.Navigation
import com.example.urrencyconverter.R
import com.example.urrencyconverter.databinding.FragmentSecondBinding
import com.example.urrencyconverter.screens.MAIN
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {


    lateinit var dialog: Dialog
    lateinit var binding: FragmentSecondBinding

    lateinit var bundle: Bundle
    var flag: Boolean = false
    var flagVyborValyt: Boolean = false
    var valuta: String = ""
    var count: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        bundle = Bundle()

        dialog = Dialog(requireContext())
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBundle()

        binding.btnName.setOnClickListener {

            Navigation.findNavController(binding.root)
                .navigate(R.id.action_secondFragment_to_startFragment)

        }

        binding.root.nextChange.setOnClickListener {
            flag = true
            flagVyborValyt = false
            putBundle()
            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }
        binding.root.nextChange2.setOnClickListener {
            flagVyborValyt = true
            flag = true
            putBundle()
            MAIN.navController.navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }
        binding.root.txtCurrentA.setOnClickListener {
            dialogCurrentChange()
        }
        binding.root.txtCurrentB.setOnClickListener {
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
            view?.txtCurrentB?.text = textCurrency.text
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
            view?.txtCurrentA?.text = textCurrency.text
            //  converterInfo(textCurrency.text.toString())
            dialog.dismiss()
        }
        exit.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }





    fun putBundle() {
        bundle.putBoolean("flag", flag)
        bundle.putBoolean("flag2", flagVyborValyt)
        if (flagVyborValyt == false) {

            bundle.putString("CurranceB", binding.txtCurrentB.text.toString())
            bundle.putString("NameB", binding.txtNameB.text.toString())

        } else {
            bundle.putString("CurranceA", binding.txtCurrentA.text.toString())
            bundle.putString("NameA", binding.txtNameA.text.toString())
        }

    }

    fun getBundle() {
        flag = arguments?.getBoolean("flag") == false
        flagVyborValyt = arguments?.getBoolean("flag2") == false
        if (flag) {
            if (flagVyborValyt == false) {
                val valuta = arguments?.getString("currency")
                binding.root.txtCurrentB.text = valuta
                val nazvanie = arguments?.getString("name")
                binding.root.txtNameB.text = nazvanie

                val valutaOld = arguments?.getString("currencyOld")
                val nameOld = arguments?.getString("nameOld")
                binding.root.txtCurrentA.text = valutaOld
                binding.root.txtNameA.text = nameOld

            } else {
                val text = arguments?.getString("currency")
                binding.root.txtCurrentA.text = text
                val text2 = arguments?.getString("name")
                binding.root.txtNameA.text = text2

                val valutaOld = arguments?.getString("currencyOld")
                val nameOld = arguments?.getString("nameOld")
                binding.root.txtCurrentB.text = valutaOld
                binding.root.txtNameB.text = nameOld

            }
        }
    }

}