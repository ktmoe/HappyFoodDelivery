package com.ktmmoe.happyfooddelivery.mvp.presenters

import android.graphics.Bitmap
import com.ktmmoe.happyfooddelivery.mvp.views.ProfileView

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface ProfilePresenter: BasePresenter<ProfileView> {
    fun onTapEdit()
    fun onTapCancel()
    fun onTapSave(userName: String, email: String)
    fun onProfileImageTaken(bitmap: Bitmap)
    fun onTapUploadProfileImage()
}