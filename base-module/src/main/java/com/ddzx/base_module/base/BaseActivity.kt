package com.ddzx.base_module.base

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ddzx.base_module.R


abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doListen()
        doObserver()
    }

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