package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.data.models.HappyFoodDeliveryModel
import com.ktmmoe.happyfooddelivery.data.models.impls.HappyFoodDeliveryModelImpl
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.OrderPresenter
import com.ktmmoe.happyfooddelivery.mvp.views.OrderView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
class OrderPresenterImpl: OrderPresenter, AbstractBasePresenter<OrderView>() {
    private val mHappyFoodDeliveryModel: HappyFoodDeliveryModel = HappyFoodDeliveryModelImpl

    override fun onTapCheckout() {
        mHappyFoodDeliveryModel.deleteAllInCart(onFailure = {
            mView.showMessage(it)
        }, onSuccess = {})

        mView.showCheckoutDialog()
        mView.showEmptyView()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mHappyFoodDeliveryModel.getOrders(onSuccess = {
            if (it.isEmpty()) mView.showEmptyView()
            else mView.displayOrderItems(it.toMutableList())
        }, onFailure = {
            mView.showEmptyView()
            mView.showMessage(it)
        })
    }

    override fun onTapAdd(orderItemVO: OrderItemVO) {
        mHappyFoodDeliveryModel.addOrderItem(orderItemVO.copy(count = orderItemVO.count + 1), onSuccess = {}, onFailure = {})
    }

    override fun onTapMinus(orderItemVO: OrderItemVO) {
        if (orderItemVO.count == 1) mHappyFoodDeliveryModel.deleteOrderItem(orderItemVO.menuName, onSuccess = {}, onFailure = {})
        else mHappyFoodDeliveryModel.addOrderItem(orderItemVO.copy(count = orderItemVO.count - 1), onSuccess = {}, onFailure = {})
    }
}