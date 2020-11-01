package com.ktmmoe.happyfooddelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ktmmoe.happyfooddelivery.R
import com.ktmmoe.happyfooddelivery.data.vos.CategoryVO
import com.ktmmoe.happyfooddelivery.viewholders.CategoriesViewHolder

/**
 * Created by ktmmoe on 29, October, 2020
 **/
class CategoriesAdapter: BaseRecyclerAdapter<CategoriesViewHolder, CategoryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_category, parent, false))
    }
}