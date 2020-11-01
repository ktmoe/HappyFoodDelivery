package com.ktmmoe.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.data.vos.MenuVO
import com.ktmmoe.happyfooddelivery.delegates.MenuItemActionDelegate
import com.ktmmoe.happyfooddelivery.viewholders.MenuViewHolder

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class MenusAdapter(val delegate: MenuItemActionDelegate): BaseRecyclerAdapter<MenuViewHolder, MenuVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_menu_list, parent, false), delegate)
    }
}