package com.example.ucanpay

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class n_pass : AppCompatActivity() {

    lateinit var new_pass: EditText
    lateinit var confirm_newpass: EditText
    lateinit var newpass_login: Button
    lateinit var npass_back: LinearLayout


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newpass)

        new_pass = findViewById(R.id.newPass)
        confirm_newpass = findViewById(R.id.confpass)
        newpass_login = findViewById(R.id.newlogin_pass)
        npass_back = findViewById(/* id = */ R.id.npass_back)

        npass_back.setOnClickListener {
            val intent = Intent (this, verification::class.java)
            startActivity(intent)
        }

        newpass_login.setOnClickListener {
            val username = new_pass.text.toString()
            val password = confirm_newpass.text.toString()
            Log.i("Test Credentials", "Username : $username and Password : $password")

            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)

        }

    }
}