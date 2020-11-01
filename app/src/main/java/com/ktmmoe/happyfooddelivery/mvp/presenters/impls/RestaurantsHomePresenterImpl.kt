package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.data.models.HappyFoodDeliveryModel
import com.ktmmoe.happyfooddelivery.data.models.impls.HappyFoodDeliveryModelImpl
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.RestaurantDetailPresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.RestaurantsHomePresenter
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHome0View
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHome1View
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantsHomeView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
class RestaurantsHomePresenterImpl: RestaurantsHomePresenter, AbstractBasePresenter<RestaurantsHomeView>() {
    private val mHappyFoodDeliveryModel: HappyFoodDeliveryModel = HappyFoodDeliveryModelImpl

    override fun onTapMyOrder() {
        mView.navigateToOrderScreen()
    }

    override fun onUiReady1(lifecycleOwner: LifecycleOwner) {
        mHappyFoodDeliveryModel.getRestaurants(
                onFailure = {mView.showMessage(it)},
                onSuccess = {
                    (mView as RestaurantsHome1View).displayPopularRestaurants(it.filter { vo-> vo.popular })
                    (mView as RestaurantsHome1View).displayNewRestaurants(it)
                }
        )
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mHappyFoodDeliveryModel.getCategories(
                onFailure = {mView.showMessage(it)},
                onSuccess = {
                    (mView as RestaurantsHome0View).displayCategories(it)
                }
        )

        mHappyFoodDeliveryModel.getRestaurants(
                onFailure = {mView.showMessage(it)},
                onSuccess = {
                    (mView as RestaurantsHome0View).displayNewRestaurants(it)
                }
        )
    }

    override fun onTapRestaurant(vo: RestaurantVO) {
        mView.navigateToRestaurantDetailScreen(vo)
    }
}