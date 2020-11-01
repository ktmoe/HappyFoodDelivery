package com.ktmmoe.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.mvp.presenters.LoginPresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.LoginPresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {
    private var viewType: Int = 0

    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(loginToolbar)
        title = ""
        viewType = intent.getIntExtra("viewType", 0)

        setupPresenter()
        setupActionListeners()
    }

    private fun setupPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
    }

    private fun setupActionListeners() {
        textViewCreateAccount.setOnClickListener {
            mPresenter.onTapSignUp()
        }

        login.setOnClickListener {
            mPresenter.onTapLogin(editTextEmail.text.toString(), editTextPassword.text.toString())
        }
    }

    companion object {
        fun intent(context: Context, viewType: Int): Intent = Intent(context, LoginActivity::class.java).apply {
            putExtra("viewType", viewType)
        }
    }

    override fun navigateToHomeScreen() {
        finishAffinity()
        startActivity(MainActivity.intent(this, viewType))
    }

    override fun navigateToSignUpScreen() {
        finish()
        startActivity(CreateAccountActivity.intent(this, viewType))
    }

}