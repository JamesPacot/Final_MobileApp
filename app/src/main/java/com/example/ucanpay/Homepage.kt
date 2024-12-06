package com.example.ucanpay

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter



class Homepage : AppCompatActivity() {

    private lateinit var imageqrcode: ImageView
    private lateinit var Ettext: EditText
    private lateinit var generateQrBtn: Button
    private lateinit var starpoints: ImageView
    private lateinit var cashin: Button
    private lateinit var transachist: Button

    private val PREFS_NAME = "MyPrefsFile"
    private val BALANCE_KEY = "balance"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        imageqrcode = findViewById(R.id.imageqrcode)
        Ettext = findViewById(R.id.Ettext)
        generateQrBtn = findViewById(R.id.generateQrBtn)
        starpoints = findViewById(R.id.star_points)
        cashin = findViewById(R.id.cash_in_butt)
        imageqrcode = findViewById(R.id.imageqrcode)
        transachist = findViewById(R.id.transac)
        val logoutButton: Button = findViewById(R.id.logout_btn)

        //cash balance textview
        val cashbalancetextview: TextView = findViewById(R.id.cash_balance)

        // Retrieve balance from SharedPreferences
        val sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        var currentBalance = sharedPreferences.getFloat(BALANCE_KEY, 0.0f)

        // Update the cash balance TextView
        cashbalancetextview.text = "Balance: ₱${currentBalance}"

        // Check if an amount was added from cash_in2
        val addedAmount = intent.getDoubleExtra("ADDED_AMOUNT", 0.0)
        if (addedAmount > 0) {
            currentBalance += addedAmount.toFloat()

            // Save updated balance
            sharedPreferences.edit().putFloat(BALANCE_KEY, currentBalance).apply()
            cashbalancetextview.text = "Balance: ₱$currentBalance"

            // Add transaction
            TransactionHistory.addTransaction("Cash-in: ₱${String.format("%.2f", addedAmount)}")

            Toast.makeText(this, "Balance updated!", Toast.LENGTH_SHORT).show()
        }



        //transaction history button
        transachist.setOnClickListener{
            val intent = Intent ( this, transaction_hist::class.java)
            startActivity(intent)
            finish()

        }
        //cash in button
        cashin.setOnClickListener{
            val intent = Intent(this, cash_in2::class.java)
            startActivity(intent)
            finish()
        }

        //starpoints
        starpoints.setOnClickListener {
            val intent = Intent(this, Pointpay::class.java)
            startActivity(intent)
            finish()
        }



        //QR Code
        generateQrBtn.setOnClickListener {

            val data = Ettext.text.toString().trim()

            if (data.isEmpty()) {
                Toast.makeText(this, "Please enter some data", Toast.LENGTH_SHORT).show()
            } else {

                val writer = QRCodeWriter()
                try {

                    val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
                    val width = bitMatrix.width
                    val height = bitMatrix.height
                    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                    for (x in 0 until width) {
                        for (y in 0 until height) {
                            bmp.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                        }
                    }

                    imageqrcode.setImageBitmap(bmp)
                } catch (e: WriterException) {
                    e.printStackTrace()
                }

            }

        }

        //Logout
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}



