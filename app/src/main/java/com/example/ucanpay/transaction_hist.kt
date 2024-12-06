package com.example.ucanpay

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class transaction_hist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_hist)

        // Reference to transaction container
        val transContainer: LinearLayout = findViewById(R.id.transactionContainer)

        // Clear previous views
        transContainer.removeAllViews()

        // Fetch and display transactions
        val allTransactions = TransactionHistory.getAllTransactions()
        if (allTransactions.isEmpty()) {
            val emptyView = TextView(this).apply {
                text = "No transactions available."
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
                setTextColor(Color.GRAY)
                setPadding(0, 10, 0, 10)
            }
            transContainer.addView(emptyView)
        } else {
            allTransactions.forEach { transaction ->
                val transactionView = TextView(this).apply {
                    text = transaction
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
                    setTextColor(Color.BLACK)
                    setPadding(0, 10, 0, 10)
                }
                transContainer.addView(transactionView)
            }
        }

        // Back to Home button functionality
        val backToHomeBtn: Button = findViewById(R.id.back_to_home_btn)
        backToHomeBtn.setOnClickListener {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
            finish()
        }
    }
}
