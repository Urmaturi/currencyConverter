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
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {

    private lateinit var viewModels: ViewModel
    lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_second, container, false)
        dialog = Dialog(requireContext())


        val textView: TextView = view.findViewById(R.id.nextChange2)
        textView.setOnClickListener {
            val toast: Toast = Toast.makeText(context, "Hello Android!", Toast.LENGTH_LONG)
            toast.show()

            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_fragmentChanegeCash)
        }


        view.nextChange.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_fragmentChanegeCash)

        }

        view.nextChange2.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_fragmentChanegeCash)
        }

        view.txtNumCur1.setOnClickListener {
            val toast: Toast = Toast.makeText(context, "Hello Android!", Toast.LENGTH_LONG)
            toast.show()
            dialogCurrentChange()

        }
       view.txtNumCur2.setOnClickListener {
            dialogCurrentChange2()
        }


        return inflater.inflate(R.layout.fragment_second, container, false)
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