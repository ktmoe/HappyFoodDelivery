package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.data.models.HappyFoodDeliveryModel
import com.ktmmoe.happyfooddelivery.data.models.impls.HappyFoodDeliveryModelImpl
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.OnBoardPresenter
import com.ktmmoe.happyfooddelivery.mvp.views.OnBoardView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
class OnBoardPresenterImpl: OnBoardPresenter, AbstractBasePresenter<OnBoardView>() {
    private val mHappyFoodDeliveryModel: HappyFoodDeliveryModel = HappyFoodDeliveryModelImpl
    override fun onContinueToOtherActivity(): Int = mHappyFoodDeliveryModel.getViewType()

    override fun onUiReady(owner: LifecycleOwner) {
        mHappyFoodDeliveryModel.setUpRemoteConfigWithDefaultValues()
        mHappyFoodDeliveryModel.fetchRemoteConfigs()
    }
}