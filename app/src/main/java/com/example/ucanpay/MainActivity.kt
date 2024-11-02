package com.example.ucanpay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var usernameInput : EditText
    lateinit var passwordInput : EditText
    lateinit var loginBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        usernameInput = findViewById(R.id.user_input)
        passwordInput = findViewById(R.id.user_input)
        loginBtn = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Log.i( "Test Credentials", "Username : $username and Password : $password")

        }

        // Set up the window insets listener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the Forgot Password TextView click listener
        val forgotPasswordTextView: TextView = findViewById(R.id.forgot_password)
        forgotPasswordTextView.setOnClickListener {
            // Handle the "Forgot password?" click action here
            // For example, navigate to a password recovery screen


        val homepageactbutton = findViewById<Button>(R.id.login_btn)
            homepageactbutton.setOnClickListener {
                val Intent = Intent( this,Homepage::class.java)
                startActivity(Intent)
            }


        }
    }
}

