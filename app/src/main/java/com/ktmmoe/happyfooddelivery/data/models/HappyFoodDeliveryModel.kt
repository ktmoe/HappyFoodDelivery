package com.ktmmoe.happyfooddelivery.data.models

import android.graphics.Bitmap
import com.ktmmoe.happyfooddelivery.data.vos.CategoryVO
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.network.FirebaseApi
import com.ktmmoe.happyfooddelivery.network.remoteconfig.FirebaseRemoteConfigManager

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface HappyFoodDeliveryModel {
    var mFirebaseApi : FirebaseApi
    var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getViewType(): Int

    fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String)-> Unit)

    fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit)

    fun getOrders(onSuccess: (List<OrderItemVO>) -> Unit, onFailure: (String) -> Unit)

    fun addOrderItem(orderItemVO: OrderItemVO, onSuccess: (String)-> Unit, onFailure: (String)->Unit)

    fun deleteOrderItem(menuName: String, onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit)

    fun deleteAllInCart(onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit)

    fun uploadImage(image: Bitmap, onSuccess: (String)-> Unit)
}