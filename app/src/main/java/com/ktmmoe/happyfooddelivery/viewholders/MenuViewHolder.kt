package com.ktmmoe.happyfooddelivery.viewholders

import android.view.View
import com.ktmmoe.happyfooddelivery.data.vos.MenuVO
import com.ktmmoe.happyfooddelivery.delegates.MenuItemActionDelegate
import kotlinx.android.synthetic.main.item_menu_list.view.*

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class MenuViewHolder(private val itemView: View, private val delegate: MenuItemActionDelegate): BaseViewHolder<MenuVO>(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                delegate.onTapMenuItem(it)
            }
        }
    }

    override fun bindData(data: MenuVO) {
        mData = data
        itemView.menuTitle.text = data.menuName
        itemView.popular.visibility = if (data.popular) View.VISIBLE else View.GONE
        itemView.price.text = String.format("$%s", "${data.price}")
    }
}