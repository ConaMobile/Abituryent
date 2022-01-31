package com.abituriyentuz.abituriyent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.abituriyentuz.abituriyent.databinding.FragmentDialogBinding
import com.abituriyentuz.abituriyent.databinding.FragmentUstozMainBinding
import kotlinx.android.synthetic.main.fragment_dialog.*
import kotlinx.android.synthetic.main.fragment_dialog.view.*

class CustomDialogFragment: DialogFragment() {
    lateinit var binding: FragmentDialogBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogBinding.inflate(layoutInflater)
        val root: View = inflater.inflate(R.layout.fragment_dialog, container, false)

        root.btn_save.setOnClickListener {

            dismiss()
        }

        return binding.root
    }

}