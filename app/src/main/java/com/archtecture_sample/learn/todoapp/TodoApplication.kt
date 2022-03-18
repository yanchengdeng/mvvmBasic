package com.archtecture_sample.learn.todoapp

import android.app.Application
import com.archtecture_sample.learn.BuildConfig
import com.ddzx.base_module.config.BaseConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 *@Author : yancheng
 *@Date : 2022/3/14
 *@Time : 14:48
 *@Describe ：
 * 一个带有@HiltAndroidApp的应用程序，它触发了Hilt的代码生成，并添加了一个应用程序级依赖容器。
 * 另外，在DEBUG BuildConfig中设置Timber。阅读Timber的生产设置文档
 **/
@HiltAndroidApp
class TodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}