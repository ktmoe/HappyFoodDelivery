package com.ktmmoe.happyfooddelivery.network.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.gson.Gson

/**
 * Created by ktmmoe on 18, October, 2020
 **/
object FirebaseRemoteConfigManager {
    private val remoteConfig = Firebase.remoteConfig

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun setupRemoteConfigWithValues() {
        val defaultValues: Map<String, Any> = hashMapOf(
            "viewType" to "0",
        )
        remoteConfig.setDefaultsAsync(defaultValues)
    }

    fun fetchRemoteConfigs() {
        remoteConfig.fetch()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    remoteConfig.activate().addOnCompleteListener {
                        Log.d("Firebase", "Firebase Remote Config activated.")
                    }
                } else {
                    Log.d("Firebase", "Firebase Remote Config fetch failed.")
                }
            }
    }

    fun getViewType(): Int = remoteConfig.getValue("viewType").asString().toInt()
}