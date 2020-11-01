package com.ktmmoe.happyfooddelivery.data.models

import com.ktmmoe.happyfooddelivery.network.auth.AuthManager

interface AuthenticationModel {
    var mAuthManager: AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
            email: String,
            password: String,
            userName: String,
            onSuccess: () -> Unit,
            onFailure: (String) -> Unit
    )

    fun getUserName(): String
    fun getPhotoUrl(): String
    fun getEmail(): String

    fun updateUserProfile(name: String, email: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun updateUserProfilePhoto(photoUri: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
}