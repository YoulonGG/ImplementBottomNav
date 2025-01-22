package com.example.implementbottomnav.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

@SuppressLint("StaticFieldLeak")
object InternetUtil {
    private var mContext: Context? = null

    fun init(context: Context) {
        if (mContext == null) {
            mContext = context
        }
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            mContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val network = connectivityManager?.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}