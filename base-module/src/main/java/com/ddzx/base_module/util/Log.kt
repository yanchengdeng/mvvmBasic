package com.ddzx.base_module.util

import timber.log.Timber

/**
 *@Author : yancheng
 *@Date : 2022/3/21
 *@Time : 9:43
 *@Describe ：日志
 **/
object Log {
    private const val TAG = "okhttp yancheng"
    fun d(string: String, tag: String = TAG) {
        Timber.d("$tag:$string")
    }

    fun w(string: String, tag: String = TAG) {
        Timber.w("$tag:$string")
    }

    fun e(string: String, tag: String = TAG) {
        Timber.e("$tag:$string")
    }

}