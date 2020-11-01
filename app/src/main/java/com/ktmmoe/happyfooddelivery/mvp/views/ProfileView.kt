package com.ktmmoe.happyfooddelivery.mvp.views

/**
 * Created by ktmmoe on 30, October, 2020
 **/
interface ProfileView: BaseView {
    fun editModeOn()
    fun editModeOff()
    fun updateProfileDisplay(name: String, email: String)
    fun updateProfileImage(url: String)
    fun openGallery()
}