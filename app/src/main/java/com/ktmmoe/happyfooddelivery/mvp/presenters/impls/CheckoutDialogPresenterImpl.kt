package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.CheckoutDialogPresenter
import com.ktmmoe.happyfooddelivery.mvp.views.CheckoutDialogView

/**
 * Created by ktmmoe on 31, October, 2020
 **/
class CheckoutDialogPresenterImpl: CheckoutDialogPresenter, AbstractBasePresenter<CheckoutDialogView>() {
    override fun onTapDismiss() {
        mView.dismiss()
    }

    override fun onUiReady(owner: LifecycleOwner) {}
}