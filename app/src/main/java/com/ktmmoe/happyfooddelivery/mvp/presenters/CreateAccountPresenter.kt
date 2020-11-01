package com.ktmmoe.happyfooddelivery.mvp.presenters

import com.ktmmoe.happyfooddelivery.mvp.views.CreateAccountView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface CreateAccountPresenter: BasePresenter<CreateAccountView> {
    fun onTapCreateAccount(userName: String, email: String, password: String)

    fun onTapLogin()
}