package com.example.ucanpay

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class cash_in2 : AppCompatActivity() {

    private lateinit var confcash: Button
    private lateinit var editTextPhone3: EditText
    private lateinit var backk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_in2)

        confcash = findViewById(R.id.confcash)
        editTextPhone3 = findViewById(R.id.editTextPhone3)
        backk = findViewById(R.id.backk)

        // Navigate back to Homepage
        backk.setOnClickListener {
            startActivity(Intent(this, Homepage::class.java))
            finish()
        }

        confcash.setOnClickListener {
            val enteredAmount = editTextPhone3.text.toString()

            if (enteredAmount.isNotEmpty()) {
                val amount = enteredAmount.toDoubleOrNull()
                if (amount != null) {
                    // Pass the amount back to Homepage
                    val intent = Intent(this, Homepage::class.java)
                    intent.putExtra("ADDED_AMOUNT", amount)
                    startActivity(intent)

                    Toast.makeText(this, "Cash-in successful!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter an amount", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
