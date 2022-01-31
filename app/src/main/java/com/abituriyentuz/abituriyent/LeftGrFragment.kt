package com.abituriyentuz.abituriyent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abituriyentuz.abituriyent.databinding.FragmentGroupBinding
import com.abituriyentuz.abituriyent.databinding.FragmentLeftGrBinding

class LeftGrFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    lateinit var binding: FragmentLeftGrBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeftGrBinding.inflate(LayoutInflater.from(context))

        binding.addCard.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }

        binding.addTestCard.setOnClickListener {
            findNavController().navigate(R.id.addTestFragment)
        }

        return binding.root
    }
}