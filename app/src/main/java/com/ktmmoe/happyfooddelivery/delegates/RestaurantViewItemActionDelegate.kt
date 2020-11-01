package com.ktmmoe.happyfooddelivery.delegates

import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface RestaurantViewItemActionDelegate {
    fun onTapRestaurant(vo: RestaurantVO)
}