package com.ktmmoe.happyfooddelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.delegates.RestaurantViewItemActionDelegate
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHomeView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface RestaurantsHomePresenter: BasePresenter<RestaurantsHomeView>, RestaurantViewItemActionDelegate {
    fun onTapMyOrder()

    fun onUiReady1(lifecycleOwner: LifecycleOwner)
}