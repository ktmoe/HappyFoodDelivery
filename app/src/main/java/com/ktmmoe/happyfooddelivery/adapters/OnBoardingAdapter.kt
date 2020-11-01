package com.ktmmoe.happyfooddelivery.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ktmmoe.happyfooddelivery.fragments.OnBoardingFragment

/**
 * Created by ktmmoe on 25, October, 2020
 **/
class OnBoardingAdapter (activity: AppCompatActivity, private val itemsCount: Int) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = itemsCount

    override fun createFragment(position: Int): Fragment = OnBoardingFragment.newInstance(position)
}