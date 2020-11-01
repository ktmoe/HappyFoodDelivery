package com.ktmmoe.happyfooddelivery.data.models.impls

import android.graphics.Bitmap
import com.ktmmoe.happyfooddelivery.data.models.HappyFoodDeliveryModel
import com.ktmmoe.happyfooddelivery.data.vos.CategoryVO
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.network.CloudFireStoreFirebaseApiImpl
import com.ktmmoe.happyfooddelivery.network.FirebaseApi
import com.ktmmoe.happyfooddelivery.network.remoteconfig.FirebaseRemoteConfigManager

/**
 * Created by ktmmoe on 30, October, 2020
 **/
object HappyFoodDeliveryModelImpl : HappyFoodDeliveryModel {
    override var mFirebaseApi: FirebaseApi = CloudFireStoreFirebaseApiImpl
    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setupRemoteConfigWithValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getViewType(): Int = mFirebaseRemoteConfigManager.getViewType()

    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getCategories(onSuccess, onFailure)
    }

    override fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getRestaurants(onSuccess, onFailure)
    }

    override fun getOrders(onSuccess: (List<OrderItemVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getOrderItems(onSuccess, onFailure)
    }

    override fun addOrderItem(orderItemVO: OrderItemVO, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.addOrderItem(orderItemVO, onSuccess, onFailure)
    }

    override fun deleteOrderItem(menuName: String, onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit) {
        mFirebaseApi.deleteOrderItem(menuName, onSuccess, onFailure)
    }

    override fun deleteAllInCart(onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit) {
        mFirebaseApi.deleteAllInCart(onSuccess, onFailure)
    }

    override fun uploadImage(image: Bitmap, onSuccess: (String) -> Unit) {
        mFirebaseApi.uploadImage(image, onSuccess)
    }
}