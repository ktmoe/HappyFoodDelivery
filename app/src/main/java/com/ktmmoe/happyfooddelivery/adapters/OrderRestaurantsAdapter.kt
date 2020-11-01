package com.ktmmoe.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.delegates.RestaurantViewItemActionDelegate
import com.ktmmoe.happyfooddelivery.viewholders.OrderRestaurantsViewHolder
import com.ktmmoe.happyfooddelivery.viewholders.RestaurantsViewHolder

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class OrderRestaurantsAdapter(): BaseRecyclerAdapter<OrderRestaurantsViewHolder, RestaurantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderRestaurantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_restaurant, parent, false)
        return OrderRestaurantsViewHolder(view)
    }
}