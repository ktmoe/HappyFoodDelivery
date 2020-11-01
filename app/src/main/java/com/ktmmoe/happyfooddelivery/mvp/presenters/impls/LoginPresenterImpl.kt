package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.data.models.AuthenticationModel
import com.ktmmoe.happyfooddelivery.data.models.impls.AuthenticationModelImpl
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.LoginPresenter
import com.ktmmoe.happyfooddelivery.mvp.views.LoginView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
class LoginPresenterImpl: LoginPresenter, AbstractBasePresenter<LoginView>() {
    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapLogin(email: String, password: String) {
        if (validateEmailPassword(email, password)) {
            mAuthenticationModel.login(email, password,
                    onSuccess = {
                        mView.navigateToHomeScreen()
                    },
                    onFailure = { mView.showMessage(it) })
        }
    }

    private fun validateEmailPassword(email: String, password: String): Boolean =
            if (email.isEmpty() || password.isEmpty()) {
                mView.showMessage("Please Fill in Full Data.")
                false
            } else true

    override fun onTapSignUp() {
        mView.navigateToSignUpScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
    }
}