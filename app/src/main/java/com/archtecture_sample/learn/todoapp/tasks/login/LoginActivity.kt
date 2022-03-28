package com.archtecture_sample.learn.todoapp.tasks.login

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.archtecture_sample.learn.R
import com.archtecture_sample.learn.databinding.ActivityLoginBinding
import com.ddzx.base_module.base.BaseActivity
import com.ddzx.base_module.data.remote.Status
import com.ddzx.base_module.view.clickNoRepeat
import dagger.hilt.android.AndroidEntryPoint

/**
 *@Describe ：标记
 **/
@AndroidEntryPoint
class LoginActivity : BaseActivity() {


    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding


    /**
     * 初始化viewBind
     */
    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
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

        findViewById<Button>(R.id.button).setOnClickListener {
            loginViewModel.getFestivalInfo()
            loginViewModel.getCalendarInfo()
        }
    }

    /**
     * 处理数据
     */
    override fun doObserver() {

        loginViewModel.apply {
            calendarResponseInfo.observe(this@LoginActivity) {

                when (it.resultStatus) {
                    Status.LOADING -> Toast.makeText(this@LoginActivity, "加载中", Toast.LENGTH_LONG)
                        .show()
                    Status.SUCCESS -> findViewById<TextView>(R.id.textView).text =
                        it.data?.get(0)?.branchHourInfo
                    Status.ERROR -> findViewById<TextView>(R.id.textView).text = "error request---${it.errMsg}"
                }
            }

            festivalInfo.observe(this@LoginActivity) {
                when (it.resultStatus) {
                    Status.LOADING -> Toast.makeText(this@LoginActivity, "加载中", Toast.LENGTH_LONG)
                        .show()
                    Status.SUCCESS -> findViewById<TextView>(R.id.textView2).text =
                        it.data?.Descption
                    Status.ERROR -> findViewById<TextView>(R.id.textView2).text = "error request---${it.errMsg}"
                }
            }
        }
    }

}