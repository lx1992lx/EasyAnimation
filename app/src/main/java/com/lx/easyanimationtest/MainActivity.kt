package com.lx.easyanimationtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import com.lx.easyanimation.EasyAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.setOnClickListener {
            EasyAnimation
                    .at(tv)
                    .rotate(0f, 360f)
                    .build(1000,AccelerateDecelerateInterpolator())
                    .connect()
                    .scale(1f,1f,1.6f,1.6f)
                    .build(1000,AccelerateDecelerateInterpolator())
                    .start {
                Toast.makeText(this, "完成", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
