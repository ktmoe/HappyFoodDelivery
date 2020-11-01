package com.ktmmoe.happyfooddelivery.mvp.views

import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO

/**
 * Created by ktmmoe on 31, October, 2020
 **/
interface RestaurantsHome1View: RestaurantsHomeView {
    fun displayPopularRestaurants(list: List<RestaurantVO>)
}