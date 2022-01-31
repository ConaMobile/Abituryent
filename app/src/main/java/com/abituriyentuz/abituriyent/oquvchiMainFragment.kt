package com.abituriyentuz.abituriyent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.abituriyentuz.abituriyent.databinding.FragmentOquvchiMainBinding
import kotlinx.android.synthetic.main.fragment_oquvchi_main.*

class oquvchiMainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    lateinit var binding: FragmentOquvchiMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOquvchiMainBinding.inflate(LayoutInflater.from(context))

        binding.cardView2.setOnClickListener {
            findNavController().navigate(R.id.groupOquvchiFragment)
        }

        return binding.root
    }
}