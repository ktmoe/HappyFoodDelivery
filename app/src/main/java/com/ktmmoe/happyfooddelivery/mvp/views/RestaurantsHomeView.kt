package com.ktmmoe.happyfooddelivery.mvp.views

import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface RestaurantsHomeView: BaseView {
    fun navigateToOrderScreen()
    fun navigateToRestaurantDetailScreen(vo: RestaurantVO)

    fun displayNewRestaurants(list: List<RestaurantVO>)
}