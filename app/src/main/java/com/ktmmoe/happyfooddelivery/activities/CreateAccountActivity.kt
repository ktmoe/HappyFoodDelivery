package com.ktmmoe.happyfooddelivery.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.mvp.presenters.CreateAccountPresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.impls.CreateAccountPresenterImpl
import com.ktmmoe.happyfooddelivery.mvp.views.CreateAccountView
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_login.*

class CreateAccountActivity : BaseActivity(), CreateAccountView {
    private var viewType = 0
    private lateinit var mPresenter: CreateAccountPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        setSupportActionBar(createAccountToolbar)
        title = ""

        viewType = intent.getIntExtra("viewType", 0)

        setupPresenter()
        setupActionListeners()
    }

    private fun setupPresenter() {
        mPresenter = getPresenter<CreateAccountPresenterImpl, CreateAccountView>()
    }

    private fun setupActionListeners() {
        textViewLogin.setOnClickListener {
            mPresenter.onTapLogin()
        }

        createAccount.setOnClickListener {
            mPresenter.onTapCreateAccount(etUsername.text.toString(), etEmail.text.toString(), etPassword.text.toString())
        }
    }

    companion object {
        fun intent(context: Context, viewType:Int): Intent = Intent(context, CreateAccountActivity::class.java)
                .apply { putExtra("viewType", viewType) }
    }

    override fun navigateToLoginScreen() {
        finish()
        startActivity(LoginActivity.intent(this, viewType))
    }
}