package com.ktmmoe.happyfooddelivery.mvp.presenters

import com.ktmmoe.happyfooddelivery.mvp.views.OnBoardView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface OnBoardPresenter: BasePresenter<OnBoardView> {
    fun onContinueToOtherActivity(): Int
}