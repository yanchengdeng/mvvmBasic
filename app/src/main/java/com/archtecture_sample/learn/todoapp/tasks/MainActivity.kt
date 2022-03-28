package com.archtecture_sample.learn.todoapp.tasks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.archtecture_sample.learn.R
import com.archtecture_sample.learn.databinding.ActivityMainBinding
import com.archtecture_sample.learn.todoapp.tasks.login.LoginActivity
import com.ddzx.base_module.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
    }

    /**
     * 处理事件
     */
    override fun doListen() {
        binding.requestData.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        binding.updateUrl.setOnClickListener {

        }

        binding.loadImage.setOnClickListener {
            startActivity(Intent(this,ImageLoadActivity::class.java))
        }

    }

    /**
     * 处理数据
     */
    override fun doObserver() {

    }
}