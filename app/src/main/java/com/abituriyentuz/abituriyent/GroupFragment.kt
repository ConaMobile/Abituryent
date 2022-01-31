package com.abituriyentuz.abituriyent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.abituriyentuz.abituriyent.Adapter.ViewPagerAdapter
import com.abituriyentuz.abituriyent.Adapter.ViewPagerAdapterUM
import com.abituriyentuz.abituriyent.databinding.FragmentGroupBinding
import com.abituriyentuz.abituriyent.databinding.FragmentLoginBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_group.view.*
import kotlinx.android.synthetic.main.item_tab_main.view.*


class GroupFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    var tabSelected = 0
    lateinit var binding: FragmentGroupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupBinding.inflate(LayoutInflater.from(context))

        //graph
        binding.root.tab_main.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tabSelected=tab?.position!!
                when (tab?.position) {
                    0 -> {
                        tab.customView?.image_tab_main?.setImageResource(R.drawable.ic_home_selected)
                    }
                    1 -> {
                        tab.customView?.image_tab_main?.setImageResource(R.drawable.ic_saqlanganlar_selected)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        tab.customView?.image_tab_main?.setImageResource(R.drawable.ic_frame_unselected)
                    }
                    1 -> {
                        tab.customView?.image_tab_main?.setImageResource(R.drawable.ic_saqlanganlar_unselected)
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        //end graph

        //adapter start

        val viewPager2 = binding.root.view_pager

        val adapter= ViewPagerAdapterUM(childFragmentManager,lifecycle)

        viewPager2.adapter = adapter

        //ViewPagerni Swipe true fale
        viewPager2.isUserInputEnabled = true

        //adapter end

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        super.onResume()
        val tabLayout = binding.root.tab_main
        TabLayoutMediator(tabLayout,binding.root.view_pager){tab,position ->

            val inflate =
                LayoutInflater.from(context).inflate(R.layout.item_tab_main, null, false)
            tab.customView = inflate

            when(position){
                0->{
                    inflate.image_tab_main.setImageResource(R.drawable.ic_frame_unselected)
                }
                1->{
                    inflate.image_tab_main.setImageResource(R.drawable.ic_saqlanganlar_unselected)
                }

            }
            if (tabSelected == position){
                inflate.image_tab_main.setImageResource(R.drawable.ic_adiblar_icon)
            }
        }.attach()


    }

}