package com.abituriyentuz.abituriyent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abituriyentuz.abituriyent.Adapter.ViewPagerAdapterTJ
import com.abituriyentuz.abituriyent.databinding.FragmentTestJavobBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_test_javob.view.*
import kotlinx.android.synthetic.main.item_tab_main3.view.*

class TestJavobFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    var tabSelected = 0
    lateinit var binding: FragmentTestJavobBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestJavobBinding.inflate(LayoutInflater.from(context))

        //graph
        binding.root.tab_main3.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tabSelected=tab?.position!!
                when (tab?.position) {
                    0 -> {
                        tab.customView?.image_tab_main3?.setImageResource(R.drawable.ic_home_selected)
                    }
                    1 -> {
                        tab.customView?.image_tab_main3?.setImageResource(R.drawable.ic_saqlanganlar_selected)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        tab.customView?.image_tab_main3?.setImageResource(R.drawable.ic_frame_unselected)
                    }
                    1 -> {
                        tab.customView?.image_tab_main3?.setImageResource(R.drawable.ic_saqlanganlar_unselected)
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        //end graph

        //adapter start

        val viewPager2 = binding.root.view_pager3

        val adapter= ViewPagerAdapterTJ(childFragmentManager,lifecycle)

        viewPager2.adapter = adapter

        //ViewPagerni Swipe true fale
        viewPager2.isUserInputEnabled = true

        //adapter end

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        super.onResume()
        val tabLayout = binding.root.tab_main3
        TabLayoutMediator(tabLayout,binding.root.view_pager3){tab,position ->

            val inflate =
                LayoutInflater.from(context).inflate(R.layout.item_tab_main3, null, false)
            tab.customView = inflate

            when(position){
                0->{
                    inflate.image_tab_main3.setImageResource(R.drawable.ic_frame_unselected)
                }
                1->{
                    inflate.image_tab_main3.setImageResource(R.drawable.ic_saqlanganlar_unselected)
                }

            }
            if (tabSelected == position){
                inflate.image_tab_main3.setImageResource(R.drawable.ic_adiblar_icon)
            }
        }.attach()


    }

}