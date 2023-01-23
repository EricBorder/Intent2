package com.example.intent2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // El botón para iniciar la camara
        val botoncamara = findViewById<Button>(R.id.Camara)


        botoncamara.setOnClickListener {
            // creamos un intent específico que iniciará el teléfono
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // llamamos a la activity treléfono
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
        var suma: Button = findViewById(R.id.suma)
        suma.setOnClickListener {
            val intento1 = Intent(this, SecondActivity::class.java)
            // Añade datos adicionales al Intent
            intento1.putExtra("NUMERO", (0..9).random())
            intento1.putExtra("NUMERO2",(0..9).random())
            // Inicia la segunda actividad
            startActivityForResult(intento1, REQUEST_SUMA)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.foto)
        val textView = findViewById<TextView>(R.id.texto)
        if (resultCode != Activity.RESULT_OK) return
        Log.d("asd", requestCode.toString())

        // Puedo distinguir diferentes acciones según el requestCode
        when (requestCode) {
            REQUEST_CAMARA -> {
                val imageBitmap = data?.extras!!.get("data") as Bitmap
                imageView.setImageBitmap(imageBitmap)
            }
            REQUEST_SUMA -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    textView.text = data.getIntExtra("Resultado",0).toString()
                }; }
        }
    }
    companion object {
        const val REQUEST_CAMARA = 1
        const val REQUEST_SUMA = 2

    }
}