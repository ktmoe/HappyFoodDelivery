package com.ktmmoe.happyfooddelivery.mvp.presenters

import com.ktmmoe.happyfooddelivery.mvp.views.CheckoutDialogView

/**
 * Created by ktmmoe on 31, October, 2020
 **/
interface CheckoutDialogPresenter: BasePresenter<CheckoutDialogView> {
    fun onTapDismiss()
}