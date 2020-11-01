package com.ktmmoe.happyfooddelivery.delegates

import com.ktmmoe.happyfooddelivery.data.vos.MenuVO

/**
 * Created by ktmmoe on 31, October, 2020
 **/
interface MenuItemActionDelegate {
    fun onTapMenuItem(menu: MenuVO)
}