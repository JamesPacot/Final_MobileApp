package com.example.ucanpay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.graphics.Bitmap
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ucanpay.databinding.ActivityHomepageBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder


class Homepage : AppCompatActivity() {

    private lateinit var imageqrcode: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)


        val qrGeneratorButton: Button = findViewById(R.id.generateQrBtn)
        val logoutButton: Button = findViewById(R.id.logout_btn)
        imageqrcode = findViewById(R.id.imageqrcode)

        qrGeneratorButton.setOnClickListener{
            val qrCodevalue = "Generate Successful"
            generateQRCode(qrCodevalue)
        }

        logoutButton.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()

        }

    }

    private fun generateQRCode(value: String) {
        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap: Bitmap = barcodeEncoder.encodeBitmap(value, BarcodeFormat.QR_CODE, 400,400)
            imageqrcode.setImageBitmap(bitmap)
         } catch (e: WriterException) {
            e.printStackTrace()
            }
        }

    }



