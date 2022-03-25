package com.archtecture_sample.learn.todoapp.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.archtecture_sample.learn.R
import com.ddzx.base_module.view.loadCircleImage
import com.ddzx.base_module.view.loadImage
import com.ddzx.base_module.view.loadRoundImage

class ImageLoadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_load)

        val url = "https://profile-avatar.csdnimg.cn/fbbb5973b2ba4a999714fc6dd99a026a_qq_42351033.jpg"
        findViewById<ImageView>(R.id.imageView1).loadImage(com.ddzx.base_module.R.drawable.completedTaskBackground )
        findViewById<ImageView>(R.id.imageView3).loadImage(url )
        findViewById<ImageView>(R.id.imageView4).loadCircleImage(url )
        findViewById<ImageView>(R.id.imageView5).loadRoundImage(url )
    }





}