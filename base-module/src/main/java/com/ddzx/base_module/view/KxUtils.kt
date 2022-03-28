package com.ddzx.base_module.view

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

/**
 *@Author : yancheng
 *@Date : 2022/3/28
 *@Time : 16:43
 *@Describe ：
 **/
@SuppressLint("StaticFieldLeak")
object  KxUtils {
    lateinit var ktContext: Context
    fun install (context : Context){
        this.ktContext = context
    }


    fun isNetworkAvailable(): Boolean {
        val manager = ktContext.applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val info = manager.activeNetworkInfo
        return null != info && info.isAvailable
    }
}