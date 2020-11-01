package com.ktmmoe.happyfooddelivery.mvp.views

import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface RestaurantDetailView: BaseView {
    fun bindData(vo: RestaurantVO)
    fun increaseCartCount(count: Int)
    fun navigateToCart()
}