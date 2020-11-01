package com.ktmmoe.happyfooddelivery.data.models.impls

import com.ktmmoe.happyfooddelivery.data.models.AuthenticationModel
import com.ktmmoe.happyfooddelivery.network.auth.AuthManager
import com.ktmmoe.happyfooddelivery.network.auth.FirebaseAuthManager

object AuthenticationModelImpl : AuthenticationModel {
    override var mAuthManager: AuthManager = FirebaseAuthManager

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.login(email, password, onSuccess, onFailure)
    }

    override fun register(email: String, password: String, userName: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mAuthManager.register(email, password, userName, onSuccess, onFailure)
    }

    override fun getUserName(): String = mAuthManager.getUserName()

    override fun getPhotoUrl(): String = mAuthManager.getPhotoUrl()

    override fun getEmail(): String = mAuthManager.getEmail()

    override fun updateUserProfile(
        name: String,
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.updateUser(name, email, onSuccess, onFailure)
    }

    override fun updateUserProfilePhoto(
        photoUri: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mAuthManager.updateUserProfilePhoto(photoUri, onSuccess, onFailure)
    }
}