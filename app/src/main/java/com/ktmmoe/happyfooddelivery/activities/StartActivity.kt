package com.ktmmoe.happyfooddelivery.activities

import android.os.Bundle
import com.ktmmoe.happyfooddelivery.R
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        setupActionListeners()
    }

    private fun setupActionListeners() {
        getStarted.setOnClickListener {
            finish()
            startActivity(OnBoardingActivity.intent(this))
        }
    }
}