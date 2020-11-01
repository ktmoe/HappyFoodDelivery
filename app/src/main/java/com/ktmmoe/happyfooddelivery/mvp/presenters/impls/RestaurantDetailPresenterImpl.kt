package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.data.models.HappyFoodDeliveryModel
import com.ktmmoe.happyfooddelivery.data.models.impls.HappyFoodDeliveryModelImpl
import com.ktmmoe.happyfooddelivery.data.vos.MenuVO
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.data.vos.orderItemVO
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.RestaurantDetailPresenter
import com.ktmmoe.happyfooddelivery.mvp.views.RestaurantDetailView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
class RestaurantDetailPresenterImpl: RestaurantDetailPresenter, AbstractBasePresenter<RestaurantDetailView>() {
    private val mHappyFoodDeliveryModel: HappyFoodDeliveryModel = HappyFoodDeliveryModelImpl
    private var currentRestaurant: RestaurantVO = RestaurantVO()
    private var menuTapControl = false

    override fun onPassedVoReceived(vo: RestaurantVO) {
        mView.bindData(vo)
        currentRestaurant = vo

        mHappyFoodDeliveryModel.getOrders(onSuccess = {orders->
            var count = 0
            orders.forEach {
                count += it.count
            }
            mView.increaseCartCount(count)
        }, onFailure = {
            mView.showMessage(it)
        })
    }

    override fun onTapGoToCart() {
        mView.navigateToCart()
    }

    override fun onTapMenuItem(menu: MenuVO) {
        menuTapControl = true
        mHappyFoodDeliveryModel.getOrders(onSuccess = {orders->
            var count = 0
            orders.forEach {
                count += it.count
            }
            if (menuTapControl) {
                menuTapControl = false
                val exist = orders.filter {
                    it.menuName == menu.menuName && it.restaurantName == currentRestaurant.restaurantName
                }

                if (exist.isEmpty())
                    addOrderItem(menu.orderItemVO(currentRestaurant, 1), count + 1)
                else addOrderItem(exist.first().copy(count = exist.first().count + 1), count + 1)
            }
        }, onFailure = {
            mView.showMessage(it)
        })
    }

    private fun addOrderItem(orderItemVO: OrderItemVO, count: Int) {
        mHappyFoodDeliveryModel.addOrderItem(
                orderItemVO,
                onSuccess = {msg->
                    mView.increaseCartCount(count)
                    mView.showMessage(msg) },
                onFailure = {msg-> mView.showMessage(msg)})
    }

    override fun onUiReady(owner: LifecycleOwner) {}

}