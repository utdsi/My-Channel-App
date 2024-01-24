package com.example.flutter_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.flutter_app.adapter.MyPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import me.relex.circleindicator.CircleIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val item = listOf<String>("The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.","The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.","The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.")
//        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
//        val circleIndicator: DotsIndicator = findViewById(R.id.circleIndicator)
//        val adapter = MyPagerAdapter(item)
//        viewPager.adapter = adapter
//
//        circleIndicator.setViewPager2(viewPager)
        button = findViewById(R.id.getStarted)
        button.setOnClickListener {

            val intent = Intent(this,login::class.java)
            startActivity(intent)
        }

        changeStatusBarColor("#ff0000")

    }

    private fun changeStatusBarColor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }
}