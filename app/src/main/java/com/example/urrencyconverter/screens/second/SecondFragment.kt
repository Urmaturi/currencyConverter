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
import androidx.navigation.Navigation
import com.example.urrencyconverter.R
import com.example.urrencyconverter.databinding.FragmentSecondBinding
import com.example.urrencyconverter.screens.MAIN
import com.example.urrencyconverter.screens.third.ListnearCurrency
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment(),ListnearCurrency {


    private lateinit var viewModels: ViewModel
    lateinit var dialog: Dialog
    lateinit var binding: FragmentSecondBinding
    var flag: Boolean = true
     lateinit var bundle: Bundle
    var flag2: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)
        bundle = Bundle()


        dialog = Dialog(requireContext())
        return binding.root
    }

    override fun onResume() {

        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       //
        bundle.getBoolean("flag2")
        if(flag2 == false)
            fillValuts()

        binding.btnName.setOnClickListener {

            Navigation.findNavController(binding.root)
                .navigate(R.id.action_secondFragment_to_startFragment)

        }


        binding.root.nextChange.setOnClickListener {
             flag = true
            //onSaveInstanceState(Bundle())

            flag2 = false
            bundle.putBoolean("flag2",flag2)
            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_thirdFragment)

        }
        binding.root.nextChange2.setOnClickListener {
            flag = false
            //onSaveInstanceState(Bundle())
            MAIN.navController.navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        binding.root.txtNumCursValut1.setOnClickListener {
            dialogCurrentChange()
        }
        binding.root.txtNumCur2.setOnClickListener {
            dialogCurrentChange2()
        }






    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState?.run {
//            putBoolean("flag",flag)
//                    }
//
//        super.onSaveInstanceState(outState)
//    }

//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//
//        //val text = savedInstanceState?.getBoolean("flag")
//        val text = bundle.getBoolean("flag")
//        val duration = Toast.LENGTH_SHORT
//
//        val toast = Toast.makeText(context, text.toString(), duration)
//        toast.show()
//    }



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
            view?.txtNumCursValut1?.text = textCurrency.text
            //  converterInfo(textCurrency.text.toString())
            dialog.dismiss()
        }
        exit.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
    fun dilig(view: View) {}


    override fun onClick(name: String, currency: String) {
        TODO("Not yet implemented")
    }


    fun fillFirstValute()
    {
        val text = arguments?.getString("currency")
        binding.root.txtNumCursValut1.text = text
        val text2 = arguments?.getString("name")
        binding.root.txtNameValut.text = text2
        bundle.putBoolean("")


    }
    fun fillSecondValute()
    {
        val text = arguments?.getString("currency")
        binding.root.txtNumCur2.text = text
        val text2 = arguments?.getString("name")
        binding.root.txtNameCur2.text = text2


    }













    fun fillValuts(){
        if(flag == false) {
            val text = arguments?.getString("currency")
            binding.root.txtNumCursValut1.text = text
            val text2 = arguments?.getString("name")
            binding.root.txtNameValut.text = text2
            flag = true
            bundle.putBoolean("flag",flag)
        }
        else
        {
            val text = arguments?.getString("currency")
            binding.root.txtNumCur2.text = text
            val text2 = arguments?.getString("name")
            binding.root.txtNameCur2.text = text2
            flag=false
            bundle.putBoolean("flag",flag)
                   }




    }





}