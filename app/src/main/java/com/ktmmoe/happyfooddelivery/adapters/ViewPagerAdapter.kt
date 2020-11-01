package com.ktmmoe.happyfooddelivery.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ktmmoe.happyfooddelivery.fragments.OnBoardingFragment
import com.ktmmoe.happyfooddelivery.fragments.ProfileFragment
import com.ktmmoe.happyfooddelivery.fragments.RestaurantsFragment
import com.ktmmoe.happyfooddelivery.fragments.RestaurantsFragment1


/**
 * Created by ktmmoe on 30, August, 2020
 **/
class ViewPagerAdapter(private val fragmentActivity: FragmentActivity, private val viewType: Int, private val itemCount: Int) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment = when(position) {
        0 -> if (viewType == 0) RestaurantsFragment.newInstance() else RestaurantsFragment1.newInstance()
        2 -> ProfileFragment.newInstance()
        else -> OnBoardingFragment.newInstance(position)
    }

    override fun getItemCount(): Int = itemCount
}