package com.ktmmoe.happyfooddelivery.network

import android.graphics.Bitmap
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.ktmmoe.happyfooddelivery.data.vos.*
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * Created by ktmmoe on 30, October, 2020
 **/
object CloudFireStoreFirebaseApiImpl: FirebaseApi {
    val db = Firebase.firestore
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun getCategories(onSuccess: (categories: List<CategoryVO>) -> Unit, onFailure: (message: String) -> Unit) {
        db.collection("categories")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check connection.")
                    } ?: run{
                        val categories : MutableList<CategoryVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for (document in result) {
                            val data = document.data
                            val categoryVO = data?.categoryVO() ?: CategoryVO()
                            categories.add(categoryVO)
                        }
                        onSuccess(categories)
                    }
                }
    }

    override fun getRestaurants(onSuccess: (list: List<RestaurantVO>) -> Unit, onFailure: (message: String) -> Unit) {
        db.collection("restaurants")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check connection.")
                    } ?: run{
                        val categories : MutableList<RestaurantVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for (document in result) {
                            val data = document.data
                            val restaurantVO = data?.restaurantVo() ?: RestaurantVO()
                            categories.add(restaurantVO)
                        }
                        onSuccess(categories)
                    }
                }
    }

    override fun getOrderItems(onSuccess: (list: List<OrderItemVO>) -> Unit, onFailure: (message: String) -> Unit) {
        db.collection("basket")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check connection")
                    } ?: run{
                        val list: MutableList<OrderItemVO> = arrayListOf()

                        val result = value?.documents ?: arrayListOf()

                        for (document in result) {
                            val data = document.data
                            val order = data?.orderItemVO() ?: OrderItemVO()
                            list.add(order)
                        }
                        onSuccess(list)
                    }
                }
    }

    override fun addOrderItem(orderItemVO: OrderItemVO, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {
        db.collection("basket")
                .document(orderItemVO.menuName)
                .set(orderItemVO.toMap())
                .addOnSuccessListener { onSuccess.invoke("Added ${orderItemVO.menuName}") }
                .addOnFailureListener { onFailure.invoke(it.localizedMessage ?: "Please check connection.") }
    }

    override fun deleteOrderItem(menuName: String, onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit) {
        db.collection("basket")
                .document(menuName)
                .delete()
                .addOnSuccessListener { onSuccess("Deleted $menuName") }
                .addOnFailureListener { onFailure("Delete Failed with ${it.localizedMessage}") }
    }

    override fun deleteAllInCart(onSuccess: (String) -> Unit, onFailure: (message: String) -> Unit) {
        db.collection("basket")
                .get()
                .addOnSuccessListener { value->
                    val result = value?.documents ?: arrayListOf()

                    for (document in result) {
                        val menuName: String = document?.data?.get("menu_name").toString() ?:""
                        db.collection("basket")
                                .document(menuName).delete()
                                .addOnSuccessListener {}
                                .addOnFailureListener { onFailure("Delete Failed 2 ${it.localizedMessage}") }
                    }
                }
    }

    override fun uploadImage(image: Bitmap, success: (String) -> Unit) {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val imageRef = storageReference.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener {
            //
        }.addOnSuccessListener { taskSnapshot ->
            //
        }

        val urlTask = uploadTask.continueWithTask {
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener { task ->
            success(task.result.toString())
        }
    }
}