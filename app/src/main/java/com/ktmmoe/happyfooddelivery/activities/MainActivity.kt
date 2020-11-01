package com.ktmmoe.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var viewType = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewType = intent.getIntExtra("viewType", 0)

        setupViewPager()
        setupBottomNavigation()
    }

    private fun setupViewPager() {
        viewpager2.adapter = ViewPagerAdapter(this,  viewType,3)
        viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigation.menu.getItem(position).isChecked = true
            }
        })
        viewpager2.isUserInputEnabled = false
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.restaurants -> viewpager2.setCurrentItem(0, true)
                R.id.offers -> viewpager2.setCurrentItem(1, true)
                R.id.account -> viewpager2.setCurrentItem(2, true)
            }
            true
        }
    }

    companion object{
        fun intent(context: Context, viewType: Int) : Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("viewType", viewType)
            return intent
        }
    }
}