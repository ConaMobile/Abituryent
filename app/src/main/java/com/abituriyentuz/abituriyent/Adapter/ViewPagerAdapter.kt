package com.abituriyentuz.abituriyent.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.abituriyentuz.abituriyent.ItemVPFragment
import com.abituriyentuz.abituriyent.Models.MyModel

class ViewPagerAdapter(val list: ArrayList<MyModel>, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ItemVPFragment.newInstance(list[position])
    }
}