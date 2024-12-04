package com.example.ucanpay

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class Pointpay : AppCompatActivity() {

    private lateinit var imageqrcode2: ImageView
    private lateinit var text2: EditText
    private lateinit var generateQrBtn2: Button
    private lateinit var backbutton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pointpay)

        text2 = findViewById(R.id.text2)
        generateQrBtn2 = findViewById(R.id.generateQrBtn2)
        backbutton = findViewById(R.id.backbtn)
        imageqrcode2 = findViewById(R.id.imageqrcode2)



        //QR Code
        generateQrBtn2.setOnClickListener {

            val data = text2.text.toString().trim()

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

                    imageqrcode2.setImageBitmap(bmp)
                } catch (e: WriterException) {
                    e.printStackTrace()
                }

            }

        }

        //Back
        backbutton.setOnClickListener {
            val intent = Intent(this, Homepage::class.java)
            startActivity(intent)
            finish()
        }

    }
}