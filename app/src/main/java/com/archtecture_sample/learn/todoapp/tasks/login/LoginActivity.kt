package com.archtecture_sample.learn.todoapp.tasks.login

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.archtecture_sample.learn.R
import com.ddzx.base_module.data.remote.Status
import dagger.hilt.android.AndroidEntryPoint

/**
 *@Describe ：标记
 **/
@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

//    private  val loginViewModel  by viewModels<LoginViewModel>()

    private val loginViewModel: LoginViewModel by viewModels()
//    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        doListen()
        doObserver()
    }

    /**
     * 处理事件
     */
    fun doListen() {
        findViewById<Button>(R.id.button).setOnClickListener {
            loginViewModel.getFestivalInfo()
            loginViewModel.getCalendarInfo()
        }
    }

    /**
     * 处理数据
     */
    fun doObserver() {

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