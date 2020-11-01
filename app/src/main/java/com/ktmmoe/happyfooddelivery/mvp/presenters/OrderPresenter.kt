package com.ktmmoe.happyfooddelivery.mvp.presenters

import com.ktmmoe.happyfooddelivery.delegates.OrderItemActionDelegate
import com.ktmmoe.happyfooddelivery.mvp.views.OrderView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface OrderPresenter: BasePresenter<OrderView>, OrderItemActionDelegate {
    fun onTapCheckout()
}