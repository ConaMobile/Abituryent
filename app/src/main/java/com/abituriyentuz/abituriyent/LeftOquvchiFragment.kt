package com.abituriyentuz.abituriyent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abituriyentuz.abituriyent.databinding.FragmentLeftOquvchiBinding
import com.abituriyentuz.abituriyent.databinding.FragmentTestJavobBinding

class LeftOquvchiFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    lateinit var binding: FragmentLeftOquvchiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeftOquvchiBinding.inflate(LayoutInflater.from(context))

        binding.addTestCard.setOnClickListener {
            findNavController().navigate(R.id.testJavobFragment)
        }

        return binding.root
    }
}