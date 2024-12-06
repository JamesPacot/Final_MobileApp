package com.example.ucanpay

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Success : AppCompatActivity() {

    private lateinit var backhome: Button
    private lateinit var successMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_success)

        backhome = findViewById(R.id.backhome_button)

        // Retrieve the added amount from intent
        val addedAmount = intent.getDoubleExtra("ADDED_AMOUNT", 0.0)

        // Back to Homepage
        backhome.setOnClickListener {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
            finish()  // Ensures the current activity is removed from the back stack
        }
    }
}
