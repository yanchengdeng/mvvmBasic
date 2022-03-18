package com.archtecture_sample.learn.todoapp.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.archtecture_sample.learn.R
import com.archtecture_sample.learn.todoapp.tasks.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this,LoginActivity::class.java)
        findViewById<Button>(R.id.requestData).setOnClickListener {
           startActivity(intent)
        }
    }
}