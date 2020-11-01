package com.ktmmoe.happyfooddelivery.mvp.views

import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface OrderView : BaseView{
    fun hideEmptyView()
    fun showEmptyView()

    fun showCheckoutDialog()
    fun displayOrderItems(list: MutableList<OrderItemVO>)
}