package com.example.ucanpay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity

class fpass : AppCompatActivity() {

    lateinit var idnumberInput: EditText
    lateinit var fpasswordInput: EditText
    lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fpassword)

        idnumberInput = findViewById(R.id.id_number)
        fpasswordInput = findViewById(R.id.f_password)
        nextButton = findViewById(R.id.nextbutton)

        nextButton.setOnClickListener {
            val username = idnumberInput.text.toString()
            val password = fpasswordInput.text.toString()
            Log.i("Test Credentials", "Username : $username and Password : $password")

            val intent = Intent(this, verification::class.java)
            startActivity(intent)
        }


    }
}