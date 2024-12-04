package com.example.ucanpay

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class verification : AppCompatActivity() {

    lateinit var code_email: EditText
    lateinit var code_next: Button
    lateinit var code_back: LinearLayout


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.codeemail)

        code_email = findViewById(R.id.enter_code)
        code_next = findViewById(R.id.nextbut)
        code_back = findViewById(R.id.code_back)

        code_back.setOnClickListener {
            val intent = Intent(this, fpass::class.java)
            startActivity(intent)
        }

        code_next.setOnClickListener {
            val username = code_email.text.toString()
            Log.i("Test Credentials", "Username : $username")

            val intent = Intent(this, n_pass::class.java)
            startActivity(intent)

        }
        }
    }
