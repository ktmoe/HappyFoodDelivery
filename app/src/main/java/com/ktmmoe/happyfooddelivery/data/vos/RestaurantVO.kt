package com.ktmmoe.happyfooddelivery.data.vos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by ktmmoe on 31, October, 2020
 **/
data class RestaurantVO (
        @SerializedName("id") var id: Int = 0,
        @SerializedName("restaurant_name") var restaurantName: String = "",
        @SerializedName("rating") var rating: Double = 0.0,
        @SerializedName("address") var address: String = "",
        @SerializedName("cover") var cover: String = "",
        @SerializedName("estimate_time") var estimateTime: String = "",
        @SerializedName("popular") var popular: Boolean = false,
        @SerializedName("menus") var menus: List<MenuVO> = emptyList()
): Serializable

fun Map<String, Any>.restaurantVo(): RestaurantVO = RestaurantVO(
        id = (this["id"] as Long).toInt(), restaurantName = this["restaurant_name"] as String,
        rating = this["rating"].toString().toDouble(), address = this["address"] as String,
        cover = this["cover"] as String, estimateTime = this["estimate_time"] as String,
        popular = this["popular"] as Boolean, menus = (this["menus"] as List<Map<String, Any>>).menuVoList()
)