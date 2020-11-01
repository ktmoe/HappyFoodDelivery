package com.ktmmoe.happyfooddelivery

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by ktmmoe on 29, October, 2020
 **/

fun String.load(context: Context, imageView: ImageView) {
    Glide.with(context)
            .load(this)
            .apply(RequestOptions().placeholder(R.drawable.ic_on_boarding_1))
            .into(imageView)
}

fun String.load(context: Context, imageView: CircleImageView) {
    Glide.with(context)
        .load(this)
        .apply(RequestOptions().placeholder(R.drawable.ic_on_boarding_1))
        .into(imageView)
}