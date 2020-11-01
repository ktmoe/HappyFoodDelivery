package com.ktmmoe.happyfooddelivery.viewholders

import android.view.View
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.load
import kotlinx.android.synthetic.main.item_order_restaurant.view.*

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class OrderRestaurantsViewHolder(private val view: View): BaseViewHolder<RestaurantVO>(view) {

    override fun bindData(data: RestaurantVO) {
        data.cover.load(view.context, itemView.restaurantCover)
        itemView.restaurantTitle.text = data.restaurantName
        itemView.rating.text = "${data.rating}"
    }
}