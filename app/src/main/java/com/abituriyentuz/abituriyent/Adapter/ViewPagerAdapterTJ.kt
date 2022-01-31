package com.abituriyentuz.abituriyent.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.abituriyentuz.abituriyent.LeftGrFragment
import com.abituriyentuz.abituriyent.RightGrFragment
import com.abituriyentuz.abituriyent.TestLeftFragment
import com.abituriyentuz.abituriyent.javobRightFragment

class ViewPagerAdapterTJ(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {

        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){

            0->{
                TestLeftFragment()
            }
            1->{
                javobRightFragment()
            }

            else->{
                Fragment()
            }

        }
    }
}
