package com.ktmmoe.happyfooddelivery.mvp.views

import com.ktmmoe.happyfooddelivery.data.vos.CategoryVO

/**
 * Created by ktmmoe on 31, October, 2020
 **/
interface RestaurantsHome0View: RestaurantsHomeView {
    fun displayCategories(list: List<CategoryVO>)
}