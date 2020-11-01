package com.ktmmoe.happyfooddelivery.data.vos

import android.util.Log
import android.view.Menu
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by ktmmoe on 31, October, 2020
 **/
data class MenuVO (
        @SerializedName("id") var id: Int = 0,
        @SerializedName("menu_name") var menuName: String = "",
        @SerializedName("price") var price: Int = 0,
        @SerializedName("cover") var cover: String = "",
        @SerializedName("popular") var popular: Boolean = false
):Serializable

fun Map<String, Any>.menuVo(): MenuVO = MenuVO(
        id = (this["id"] as Long).toInt(), menuName = this["menu_name"] as String,
        price = (this["price"] as Long).toInt(), cover = this["cover"] as String,
        popular = this["popular"] as Boolean
)

fun List<Map<String, Any>>.menuVoList(): List<MenuVO> = this.map {
    it.menuVo()
}