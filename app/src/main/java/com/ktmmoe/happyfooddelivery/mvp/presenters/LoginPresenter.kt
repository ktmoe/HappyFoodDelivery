package com.ktmmoe.happyfooddelivery.mvp.presenters

import com.ktmmoe.happyfooddelivery.mvp.views.LoginView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(email: String, password: String)
    fun onTapSignUp()
}