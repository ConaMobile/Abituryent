package com.abituriyentuz.abituriyent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abituriyentuz.abituriyent.databinding.FragmentAddTestBinding

class addTestFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    lateinit var binding: FragmentAddTestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTestBinding.inflate(LayoutInflater.from(context))

        binding.saveBtn.setOnClickListener {
            findNavController().navigate(R.id.leftGrFragment)
        }

        return binding.root
    }
}