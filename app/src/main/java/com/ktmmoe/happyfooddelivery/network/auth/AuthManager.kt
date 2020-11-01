package com.ktmmoe.happyfooddelivery.network.auth

interface AuthManager {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, userName: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun getUserName() : String
    fun getPhotoUrl(): String
    fun getEmail(): String

    fun updateUser(name: String, email: String,  onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun updateUserProfilePhoto(photoUri: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
}