package com.ktmmoe.happyfooddelivery.delegates

import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO

/**
 * Created by ktmmoe on 31, October, 2020
 **/
interface OrderItemActionDelegate {
    fun onTapAdd(orderItemVO: OrderItemVO)
    fun onTapMinus(orderItemVO: OrderItemVO)
}