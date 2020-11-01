package com.ktmmoe.happyfooddelivery.mvp.presenters.impls

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.ktmmoe.happyfooddelivery.data.models.AuthenticationModel
import com.ktmmoe.happyfooddelivery.data.models.HappyFoodDeliveryModel
import com.ktmmoe.happyfooddelivery.data.models.impls.AuthenticationModelImpl
import com.ktmmoe.happyfooddelivery.data.models.impls.HappyFoodDeliveryModelImpl
import com.ktmmoe.happyfooddelivery.mvp.presenters.AbstractBasePresenter
import com.ktmmoe.happyfooddelivery.mvp.presenters.ProfilePresenter
import com.ktmmoe.happyfooddelivery.mvp.views.ProfileView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
class ProfilePresenterImpl: ProfilePresenter, AbstractBasePresenter<ProfileView>() {

    private val mHappyFoodDeliveryModel: HappyFoodDeliveryModel = HappyFoodDeliveryModelImpl
    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapEdit() {
        mView.editModeOn()
    }

    override fun onTapCancel() {
        mView.editModeOff()
    }

    override fun onTapSave(userName: String, email: String) {
        mView.editModeOff()
        mAuthenticationModel.updateUserProfile(userName, email,
        onSuccess = {
            mView.updateProfileDisplay(userName, email)
        }, onFailure = {
                mView.showMessage(it)
            })
    }

    override fun onProfileImageTaken(bitmap: Bitmap) {
        mHappyFoodDeliveryModel.uploadImage(bitmap){url->
            mAuthenticationModel.updateUserProfilePhoto(url, onSuccess = {mView.updateProfileImage(url)}, onFailure = {
                mView.showMessage(it)
            })
        }
    }

    override fun onTapUploadProfileImage() {
        mView.openGallery()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        val userName = mAuthenticationModel.getUserName()
        val photoUrl = mAuthenticationModel.getPhotoUrl()
        val email = mAuthenticationModel.getEmail()
        mView.updateProfileDisplay(userName, email)
        mView.updateProfileImage(photoUrl)
    }
}