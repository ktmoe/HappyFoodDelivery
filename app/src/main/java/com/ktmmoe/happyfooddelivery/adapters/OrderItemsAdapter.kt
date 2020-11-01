package com.ktmmoe.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.delegates.OrderItemActionDelegate
import com.ktmmoe.happyfooddelivery.viewholders.OrderItemsViewHolder

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class OrderItemsAdapter(private val delegate: OrderItemActionDelegate): BaseRecyclerAdapter<OrderItemsViewHolder, OrderItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemsViewHolder {
        return OrderItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_order_list, parent, false), delegate)
    }
}