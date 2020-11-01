package com.ktmmoe.happyfooddelivery.network.auth

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

object FirebaseAuthManager : AuthManager {

    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful && it.isComplete){
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "Please Check Internet Connection")
            }
        }
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {

                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder().setDisplayName(userName).build()
                )
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "Please check internet connection")
            }
        }
    }

    override fun getUserName(): String {
        return mFirebaseAuth.currentUser?.displayName ?: ""
    }

    override fun getPhotoUrl(): String = mFirebaseAuth.currentUser?.photoUrl.toString() ?: ""

    override fun getEmail(): String = mFirebaseAuth.currentUser?.email ?: ""

    override fun updateUser(
        name: String,
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.currentUser?.updateProfile(
            UserProfileChangeRequest.Builder().setDisplayName(name)
                .build()
        )?.addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
                mFirebaseAuth.currentUser?.updateEmail(email)
                onSuccess.invoke()
            } else {
                onFailure(it.exception?.localizedMessage ?: "Please check internet connection")
            }
        }
    }

    override fun updateUserProfilePhoto(
        photoUri: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.currentUser?.updateProfile(
            UserProfileChangeRequest.Builder().setPhotoUri(Uri.parse(photoUri))
                .build()
        )?.addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
                onSuccess.invoke()
            } else {
                onFailure(it.exception?.localizedMessage ?: "Please check internet connection")
            }
        }
    }
}