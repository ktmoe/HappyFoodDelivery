package com.ktmmoe.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUiReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}