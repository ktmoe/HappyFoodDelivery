package com.ktmmoe.happyfooddelivery.viewholders

import android.view.View
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.delegates.OrderItemActionDelegate
import kotlinx.android.synthetic.main.item_order_list.view.*

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class OrderItemsViewHolder(private val itemView: View, private val delegate: OrderItemActionDelegate): BaseViewHolder<OrderItemVO>(itemView) {

    override fun bindData(data: OrderItemVO) {
        itemView.orderItemName.text = String.format("${data.menuName} x ${data.count}")
        itemView.price.text = String.format("$${data.price * data.count}")

        itemView.add.setOnClickListener { delegate.onTapAdd(data) }
        itemView.minus.setOnClickListener { delegate.onTapMinus(data) }
    }
}