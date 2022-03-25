package com.ddzx.base_module.config

import okhttp3.Headers

/**
 *@Author : yancheng
 *@Date : 2022/3/15
 *@Time : 17:51
 *@Describe ：基础配置
 * 1.接口api  host
 * 2.接口响应码 及对应提示信息
 * 3.
 **/
object BaseConfig {

    /**
     * 设置默认headers
     */
    val headers: Headers = Headers.Builder().add("token","1231434").build()


}