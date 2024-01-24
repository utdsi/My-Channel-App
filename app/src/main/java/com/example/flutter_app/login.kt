package com.example.flutter_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class login : AppCompatActivity() {

    private var checkBox:Boolean = false
    private var eyeCheck:Boolean = false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        changeStatusBarColor("#ff0000")


        val eyeBtn = findViewById<ImageView>(R.id.toggleLoginEye)
        val checkBtn = findViewById<ImageView>(R.id.rememberCheckbox)
        val passwordText = findViewById<EditText>(R.id.loginPassword)
        val redirectSignup = findViewById<Button>(R.id.redirectSignup)
        val redirectResetPassword = findViewById<TextView>(R.id.redirectResetPassword)

        redirectResetPassword.setOnClickListener {
            val intent = Intent(this,reset_password::class.java)
            startActivity(intent)

        }
        redirectSignup.setOnClickListener {

            val intent = Intent(this,signup::class.java)
            startActivity(intent)
        }

        eyeBtn.setOnClickListener {

            if(eyeCheck){
                eyeBtn.setImageResource(R.drawable.open_eye)
                passwordText.transformationMethod = null
                eyeCheck = false
            }else{
                eyeBtn.setImageResource(R.drawable.closeeye)
                eyeCheck = true
                passwordText.transformationMethod = PasswordTransformationMethod.getInstance()
            }


        }

        checkBtn.setOnClickListener {
            if(checkBox){
                checkBtn.setImageResource(R.drawable.remembermecheck)
                checkBox = false
            }else{
                checkBtn.setImageResource(R.drawable.rememberme)
                checkBox = true
            }
        }


    }
    private fun changeStatusBarColor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }
    override fun onBackPressed() {
        // Do nothing to restrict the back button
        // You can add your custom logic here if needed
    }
}