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
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter



class Homepage : AppCompatActivity() {

    private lateinit var imageqrcode: ImageView
    private lateinit var Ettext: EditText
    private lateinit var generateQrBtn: Button
    private lateinit var starpoints: ImageView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        imageqrcode = findViewById(R.id.imageqrcode)
        Ettext = findViewById(R.id.Ettext)
        generateQrBtn = findViewById(R.id.generateQrBtn)
        starpoints = findViewById(R.id.star_points)

        starpoints.setOnClickListener{
            val intent = Intent (this, Pointpay::class.java)
            startActivity(intent)
            finish()
        }
        val qrGeneratorButton: Button = findViewById(R.id.generateQrBtn)
        val logoutButton: Button = findViewById(R.id.logout_btn)
        imageqrcode = findViewById(R.id.imageqrcode)


        //QR Code
        qrGeneratorButton.setOnClickListener {

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



