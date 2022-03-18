package com.ddzx.base_module.util

import com.ddzx.base_module.data.error.API_OK
import com.ddzx.base_module.data.error.NETWORK_ERROR
import com.ddzx.base_module.data.error.NO_INTERNET_CONNECTION
import com.ddzx.base_module.data.remote.Resource
import retrofit2.Response
import java.io.IOException

/**
 *@Author : yancheng
 *@Date : 2022/3/18
 *@Time : 16:45
 *@Describe ：
 **/
object JsonUtils {

    /**
     * 数据解析
     */
    inline fun <reified T> json2Data(response: Resource<T>): Resource<T> {
//            NO_INTERNET_CONNECTION -> Resource.error(msg = "无网络", status = NO_INTERNET_CONNECTION)
//            NETWORK_ERROR -> Resource.error(msg = "网络异常", status = NETWORK_ERROR)
//            is Int -> Resource.error(msg = "异常", status = response.status)
        return if (response.status == API_OK) {
            Resource.success(response.data)
        } else {
            Resource.error(response.status, response.errMsg)
        }
    }

    /**
     * 获取网络数据
     */
    suspend fun processCall(
        networkConnectivity: NetworkConnectivity,
        responseCall: suspend () -> Response<*>
    ): Any? {
        if (!networkConnectivity.isConnected()) {
            return NO_INTERNET_CONNECTION
        }
        return try {
            val response = responseCall.invoke()
            val responseCode = response.code()
            if (response.isSuccessful) {
                response.body()
            } else {
                responseCode
            }
        } catch (e: IOException) {
            NETWORK_ERROR
        }
    }
}