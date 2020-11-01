package com.ktmmoe.happyfooddelivery.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 31, October, 2020
 **/
data class OrderItemVO (
        @SerializedName("restaurant_name") var restaurantName: String = "",
        @SerializedName("restaurant_rating") var restaurantRating: Double = 0.0,
        @SerializedName("restaurant_address") var restaurantAddress: String = "",
        @SerializedName("restaurant_cover") var restaurantCover: String = "",
        @SerializedName("menu_name") var menuName: String = "",
        @SerializedName("count") var count : Int = 0,
        @SerializedName("price") var price: Int = 0
)

fun MenuVO.orderItemVO(restaurantVO: RestaurantVO, count: Int): OrderItemVO = OrderItemVO(
        restaurantName = restaurantVO.restaurantName,
        restaurantRating = restaurantVO.rating,
        restaurantAddress = restaurantVO.address,
        restaurantCover = restaurantVO.cover,
        menuName = menuName,
        count =  count,
        price = price
)

fun Map<String, Any>.orderItemVO(): OrderItemVO = OrderItemVO(
        restaurantName = this["restaurant_name"] as String,
        restaurantRating = this["restaurant_rating"].toString().toDouble(),
        restaurantAddress = this["restaurant_address"] as String,
        restaurantCover = this["restaurant_cover"].toString(),
        menuName = this["menu_name"] as String,
        count =  this["count"].toString().toInt(),
        price = this["price"].toString().toInt()
)

fun OrderItemVO.toMap(): Map<String, Any> = hashMapOf(
        "restaurant_name" to restaurantName,
        "restaurant_rating" to restaurantRating,
        "restaurant_address" to restaurantAddress,
        "restaurant_cover" to restaurantCover,
        "menu_name" to menuName,
        "count" to count,
        "price" to price
)