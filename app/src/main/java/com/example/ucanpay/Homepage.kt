package com.example.ucanpay

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.graphics.Bitmap
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
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
            Log.d("QRCode", "Generate QR Code : $value")
            val barcodeEncoder = BarcodeEncoder()
            val bitmap: Bitmap = barcodeEncoder.encodeBitmap(value, BarcodeFormat.QR_CODE, 100,100)
            imageqrcode.setImageBitmap(bitmap)
         } catch (e: WriterException) {
             Log.e("QRCodeError", "Error Generating QR Code", e)
            e.printStackTrace()
            }
        }

    }



