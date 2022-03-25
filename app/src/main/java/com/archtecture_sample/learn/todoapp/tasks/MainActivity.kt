package com.archtecture_sample.learn.todoapp.tasks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.archtecture_sample.learn.R
import com.archtecture_sample.learn.todoapp.tasks.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var change = true
        val intent = Intent(this, LoginActivity::class.java)
        findViewById<Button>(R.id.requestData).setOnClickListener {
            startActivity(intent)
        }


        findViewById<Button>(R.id.updateUrl).setOnClickListener {
        }

        findViewById<Button>(R.id.loadImage).setOnClickListener {
            startActivity(Intent(this,ImageLoadActivity::class.java))
        }

    }
}