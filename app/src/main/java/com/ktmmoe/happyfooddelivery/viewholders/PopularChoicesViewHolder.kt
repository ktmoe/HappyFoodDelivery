package com.ktmmoe.happyfooddelivery.viewholders

import android.view.View
import com.ktmmoe.happyfooddelivery.data.vos.MenuVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.load
import com.ktmmoe.happyfooddelivery.utils.burger1
import kotlinx.android.synthetic.main.item_menu_horizontal.view.*

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class PopularChoicesViewHolder(itemView: View): BaseViewHolder<MenuVO>(itemView) {

    override fun bindData(data: MenuVO) {
        data.cover.load(itemView.context, itemView.restaurantCover)
        itemView.menuTitle.text = data.menuName
        itemView.price.text = String.format("$%s", "${data.price}")
    }
}