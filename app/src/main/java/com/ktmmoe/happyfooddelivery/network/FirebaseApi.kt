package com.ktmmoe.happyfooddelivery.network

import android.graphics.Bitmap
import com.ktmmoe.happyfooddelivery.data.vos.CategoryVO
import com.ktmmoe.happyfooddelivery.data.vos.OrderItemVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface FirebaseApi {
    fun getCategories(onSuccess: (categories: List<CategoryVO>) -> Unit, onFailure: (message: String)-> Unit)
    fun getRestaurants(onSuccess: (list: List<RestaurantVO>) -> Unit, onFailure: (message: String)-> Unit)
    fun getOrderItems(onSuccess: (list: List<OrderItemVO>) -> Unit, onFailure: (message: String) -> Unit)

    fun addOrderItem(orderItemVO: OrderItemVO, onSuccess: (String)-> Unit, onFailure: (String)->Unit)
    fun deleteOrderItem(menuName: String, onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit)
    fun deleteAllInCart(onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit)

    fun uploadImage(image: Bitmap, success: (String) -> Unit)
}