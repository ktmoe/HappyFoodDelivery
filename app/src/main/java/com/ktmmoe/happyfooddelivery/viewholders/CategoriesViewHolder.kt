package com.ktmmoe.happyfooddelivery.viewholders

import android.view.View
import com.ktmmoe.happyfooddelivery.data.vos.CategoryVO
import com.ktmmoe.happyfooddelivery.load
import kotlinx.android.synthetic.main.item_restaurant_category.view.*

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class CategoriesViewHolder(itemView: View): BaseViewHolder<CategoryVO>(itemView) {

    override fun bindData(data: CategoryVO) {
        data.cover.load(itemView.context, itemView.categoryCover)
        itemView.categoryTitle.text = data.name
    }
}