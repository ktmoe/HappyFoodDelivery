package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.data.models.AuthenticationModel
import com.ktmmoe.happyfooddelivery.data.models.impls.AuthenticationModelImpl
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.CreateAccountPresenter
import com.ktmmoe.happyfooddelivery.mvp.views.CreateAccountView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
class CreateAccountPresenterImpl: CreateAccountPresenter, AbstractBasePresenter<CreateAccountView>() {
    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapCreateAccount(userName: String, email: String, password: String) {
        if (validateInputs(userName, email, password)) {
            mAuthenticationModel.register(email, password, userName,
                    onSuccess = {
                        mView.navigateToLoginScreen()
                    }, onFailure = {
                mView.showMessage(it)
            })
        }
    }

    private fun validateInputs(userName: String, email: String, password: String): Boolean =
            if (userName.isEmpty() || email.isEmpty() || password.isEmpty()){
                mView.showMessage("Please fill in full data.")
                false
            } else true

    override fun onTapLogin() {
        mView.navigateToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {
    }
}