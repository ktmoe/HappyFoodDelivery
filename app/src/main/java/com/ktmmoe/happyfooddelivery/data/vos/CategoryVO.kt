package com.ktmmoe.happyfooddelivery.data.vos

import com.google.gson.annotations.SerializedName

/**
 * Created by ktmmoe on 31, October, 2020
 **/
data class CategoryVO (
        @SerializedName("id") var id : Int = 0,
        @SerializedName("name") var name: String = "",
        @SerializedName("cover") var cover: String = ""
)

fun Map<String, Any>.categoryVO() : CategoryVO = CategoryVO(id = (this["id"] as Long).toInt(), name = this["name"] as String, cover = this["cover"] as String)