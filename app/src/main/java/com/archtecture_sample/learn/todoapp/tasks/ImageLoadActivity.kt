package com.archtecture_sample.learn.todoapp.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.archtecture_sample.learn.R
import com.archtecture_sample.learn.databinding.ActivityImageLoadBinding
import com.ddzx.base_module.base.BaseActivity
import com.ddzx.base_module.view.loadCircleImage
import com.ddzx.base_module.view.loadImage
import com.ddzx.base_module.view.loadRoundImage

class ImageLoadActivity : BaseActivity() {
    
    private lateinit var binding: ActivityImageLoadBinding

    /**
     * 初始化viewBind
     */
    override fun initViewBinding() {
        binding = ActivityImageLoadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    /**
     * 初始化数据
     */
    override fun initData() {
        val url = "https://profile-avatar.csdnimg.cn/fbbb5973b2ba4a999714fc6dd99a026a_qq_42351033.jpg"
        binding.imageView1.loadImage(com.ddzx.base_module.R.drawable.completedTaskBackground )
        binding.imageView3.loadImage(url )
        binding.imageView4.loadCircleImage(url )
        binding.imageView5.loadRoundImage(url )

    }

    /**
     * 处理事件
     */
    override fun doListen() {
    }

    /**
     * 处理数据
     */
    override fun doObserver() {
    }


}