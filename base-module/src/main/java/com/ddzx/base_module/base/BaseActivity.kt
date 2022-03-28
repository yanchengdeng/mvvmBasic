package com.ddzx.base_module.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        initData()
        doListen()
        doObserver()
    }

    /**
     * 初始化viewBind
     */
    protected abstract fun initViewBinding()

    /**
     * 初始化数据
     */
    abstract fun initData()


    /**
     * 处理事件
     */
    abstract fun doListen()

    /**
     * 处理数据
     */
    abstract fun doObserver()

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}