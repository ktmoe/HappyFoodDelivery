package com.ktmmoe.happyfooddelivery.mvp.presenters

import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.delegates.MenuItemActionDelegate
import com.ktmmoe.happyfooddelivery.delegates.RestaurantViewItemActionDelegate
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantDetailView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface RestaurantDetailPresenter: BasePresenter<RestaurantDetailView>, MenuItemActionDelegate {
    fun onPassedVoReceived(vo: RestaurantVO)
    fun onTapGoToCart()
}