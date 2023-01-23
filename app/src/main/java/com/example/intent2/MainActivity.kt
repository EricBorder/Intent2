package com.example.intent2

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // El botón para iniciar la camara
        val callButton = findViewById<Button>(R.id.Camara)


        callButton.setOnClickListener {
            // creamos un intent específico que iniciará el teléfono
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // llamamos a la activity treléfono
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.foto)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            val imageBitmap = data.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }
}