package com.ktmmoe.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.adapters.OnBoardingAdapter
import com.ktmmoe.happyfooddelivery.mvp.presenters.OnBoardPresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.OnBoardPresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.OnBoardView
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : BaseActivity(), OnBoardView {
    private lateinit var onBoardingAdapter: OnBoardingAdapter
    private lateinit var mPresenter: OnBoardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        prepareUi()
        setupActionListeners()
        setupPresenter()
        mPresenter.onUiReady(this)
    }

    private fun setupPresenter() {
        mPresenter = getPresenter<OnBoardPresenterImpl, OnBoardView>()
    }

    private fun setupActionListeners() {
        createAccount.setOnClickListener {
            startActivity(CreateAccountActivity.intent(this, mPresenter.onContinueToOtherActivity()))
        }
    }

    private fun prepareUi() {
        setSupportActionBar(findViewById(R.id.onBoardToolbar))
        title = ""

        val numberOfScreens = resources.getStringArray(R.array.on_board_titles).size
        onBoardingAdapter = OnBoardingAdapter(this, numberOfScreens)
        viewPager2.adapter = onBoardingAdapter
        viewPager2.registerOnPageChangeCallback(onBoardingPageChangeCallback)
    }

    private val onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            updateCircleMarker(position)
        }
    }

    private fun updateCircleMarker(position: Int) {
        when (position) {
            0 -> firstSelected()
            1 -> middleSelected()
            2-> lastSelected()
        }
    }

    private fun firstSelected() {
        onBoardingInitialCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_selected)
        onBoardingMiddleCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unselected)
        onBoardingLastCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unselected)
    }

    private fun middleSelected() {
        onBoardingMiddleCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_selected)
        onBoardingInitialCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unselected)
        onBoardingLastCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unselected)
    }

    private fun lastSelected() {
        onBoardingLastCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_selected)
        onBoardingMiddleCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unselected)
        onBoardingInitialCircle.background = ContextCompat.getDrawable(this, R.drawable.bg_circle_unselected)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.onboard_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.login) startActivity(LoginActivity.intent(this, mPresenter.onContinueToOtherActivity()))
        return true
    }

    override fun onDestroy() {
        viewPager2.unregisterOnPageChangeCallback(onBoardingPageChangeCallback)
        super.onDestroy()
    }

    companion object{
        fun intent(context: Context) : Intent = Intent(context, OnBoardingActivity::class.java)
    }
}