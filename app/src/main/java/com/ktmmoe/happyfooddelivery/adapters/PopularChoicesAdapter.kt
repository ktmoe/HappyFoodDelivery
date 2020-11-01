package com.ktmmoe.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.data.vos.MenuVO
import com.ktmmoe.happyfooddelivery.data.vos.RestaurantVO
import com.ktmmoe.happyfooddelivery.viewholders.PopularChoicesViewHolder

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class PopularChoicesAdapter: BaseRecyclerAdapter<PopularChoicesViewHolder, MenuVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoicesViewHolder {
        return PopularChoicesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_menu_horizontal, parent, false))
    }
}