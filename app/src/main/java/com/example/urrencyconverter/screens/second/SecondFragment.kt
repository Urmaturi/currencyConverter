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
import kotlinx.android.synthetic.main.fragment_item_currency.view.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {


    lateinit var dialog: Dialog
    lateinit var binding: FragmentSecondBinding

    lateinit var bundle: Bundle
    var flag: Boolean = false
    var flagVyborValyt: Boolean = false

    var nominalA: Int = 1
    var nominalB: Int = 1
    var valutaA: Double = 1.0
    var valutaB: Double = 1.0


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
            calculation2()
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
            calculation1()
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

            bundle.putString("CurranceB", valutaB.toString())
            bundle.putString("NameB", binding.txtNameB.text.toString())
            bundle.putInt("nominalB", nominalB)

        } else {
            bundle.putString("CurranceA", valutaA.toString())
            bundle.putString("NameA", binding.txtNameA.text.toString())
            bundle.putInt("nominalA", nominalA)
        }

    }

    fun getBundle() {
        flag = arguments?.getBoolean("flag") == false
        flagVyborValyt = arguments?.getBoolean("flag2") == false
        if (flag) {
            if (flagVyborValyt == false) {
                val valuta = arguments?.getString("currency")

                valutaB = valuta?.toDouble()!!

                //binding.root.txtCurrentB.text = valuta
                val nazvanie = arguments?.getString("name")
                binding.root.txtNameB.text = nazvanie
                val valutaOld = arguments?.getString("currencyOld")
                valutaA = valutaOld?.toDouble()!!

                val nameOld = arguments?.getString("nameOld")
                //binding.root.txtCurrentA.text = valutaOld
                binding.root.txtNameA.text = nameOld
                nominalB = arguments?.getInt("nominal")!!
                nominalA = arguments?.getInt("nominalOld")!!

            } else {
                val valuta = arguments?.getString("currency")
                valutaA = valuta?.toDouble()!!

                //binding.root.txtCurrentA.text = valuta
                val nazvanie = arguments?.getString("name")
                binding.root.txtNameA.text = nazvanie

                val valutaOld = arguments?.getString("currencyOld")
                valutaB = valutaOld?.toDouble()!!

                val nameOld = arguments?.getString("nameOld")
                //binding.root.txtCurrentB.text = valutaOld
                binding.root.txtNameB.text = nameOld

                nominalA = arguments?.getInt("nominal")!!
                nominalB = arguments?.getInt("nominalOld")!!

            }
        }
    }

    fun calculation1() {
        try {
            var temp: Double
            var otvet: Double
//            if (nominalA != nominalB)
//                if ( nominalA >  nominalB) {
//                    //temp = valutaA / nominalA / valutaB
//                    //textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  first"
//                    // textViewTemp.text = (temp * valutaB).toString()
//                    temp = txtCurrentA.text.toString().toDouble()
//                    otvet = temp * valutaB
//                    txtCurrentB.text = otvet.toString()
//                } else {
//                    temp = valutaA / nominalA / valutaB
//                    textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  second"
//                    temp = txtCurrentA.text.toString().toDouble()
//                    otvet = (valutaA / nominalA / valutaB) * temp
//                    txtCurrentB.text = otvet.toString()
//                }
//            else {
//                if ( nominalA > nominalB) {
//                    //temp = valutaA / nominalA / valutaB
//                    //textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  first"
//                    // textViewTemp.text = (temp * valutaB).toString()
//                    temp = txtCurrentA.text.toString().toDouble()
//                    otvet = valutaA / valutaB * temp
//                    txtCurrentB.text = otvet.toString()
//                } else {
//                    temp = valutaA / nominalA / valutaB
//                    textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  second"
//                    temp = txtCurrentA.text.toString().toDouble()
//                    otvet = (valutaA / nominalA / valutaB) * temp
//                    txtCurrentB.text = otvet.toString()
//                }
//            }

            when
            {
                nominalA == nominalB -> {

                }
                nominalA>nominalB -> {
                    temp = valutaA / nominalA / valutaB
                    textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  second"
                    temp = txtCurrentA.text.toString().toDouble()
                    otvet = (valutaA / nominalA / valutaB) * temp
                    txtCurrentB.text = otvet.toString()
                }
                nominalA<nominalB -> {
                    temp = txtCurrentA.text.toString().toDouble()
//                    //textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  first"
//                    // textViewTemp.text = (temp * valutaB).toString()
//                    temp = txtCurrentA.text.toString().toDouble()
                    otvet = temp * valutaB
                    txtCurrentB.text = otvet.toString()
                                    }

                else -> { }
            }





        } catch (e: Exception) {

        } finally {

        }

    }

    fun calculation2() {
        try {
            var temp: Double
            val otvet: Double

            if (valutaA / nominalA > valutaB / nominalB) {
                //temp = valutaA / nominalA / valutaB
                //textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  first"
                // textViewTemp.text = (temp * valutaB).toString()
                temp = txtCurrentB.text.toString().toDouble()
                otvet = temp * valutaB
                txtCurrentB.text = otvet.toString()
            } else {
                temp = valutaA / nominalA / valutaB
                textViewTemp.text = "$valutaA / $nominalA / $valutaB = $temp  second"
                temp = txtCurrentA.text.toString().toDouble()
                otvet = (valutaA / nominalA / valutaB) * temp
                txtCurrentA.text = otvet.toString()
            }

        } catch (e: Exception) {

        } finally {

        }

    }

}