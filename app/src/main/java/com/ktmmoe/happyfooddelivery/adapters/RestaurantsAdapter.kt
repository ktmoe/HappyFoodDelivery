package com.ktmmoe.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.delegates.RestaurantViewItemActionDelegate
import com.ktmmoe.happyfooddelivery.viewholders.RestaurantsViewHolder

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class RestaurantsAdapter(private val viewType: Int, private val delegate: RestaurantViewItemActionDelegate): BaseRecyclerAdapter<RestaurantsViewHolder, RestaurantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val view = when(viewType) {
            0 -> LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_large, parent, false)
            1 -> LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_horizontal, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_list, parent, false)
        }
        return RestaurantsViewHolder(view, delegate)
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }
}