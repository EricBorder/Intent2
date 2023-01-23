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

    // Constante para la captura de la imagen
    val REQUEST_IMAGE_CAPTURE = 1

    // Variables de números random para hacer la suma
    val random = (0..9).random()
    val random2 = (0..9).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // El botón para iniciar la cámara
        val botoncamara = findViewById<Button>(R.id.Camara)
        // Escuchador del botón de la cámara
        botoncamara.setOnClickListener {
            // creamos un intent específico que iniciará el teléfono
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // llamamos a la activity del teléfono
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
        // El botón para iniciar la suma
        var botonsuma: Button = findViewById(R.id.suma)
        // Escuchador del boton de la suma
        botonsuma.setOnClickListener {
            // Creamos un intent específico que iniciará la suma
            val intento1 = Intent(this, SecondActivity::class.java)
            // Añade datos adicionales al Intent
            intento1.putExtra("NUMERO", random)
            intento1.putExtra("NUMERO2", random2)
            // Inicia la segunda actividad
            startActivityForResult(intento1, REQUEST_SUMA)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Variable donde se recoge la imagen en el layout
        val imageView = findViewById<ImageView>(R.id.foto)
        //Variable donde se recofe el texto en el layout
        val textView = findViewById<TextView>(R.id.texto)

        if (resultCode != Activity.RESULT_OK) return
        Log.d("asd", requestCode.toString())

        // Puedo distinguir diferentes acciones según el requestCode
        when (requestCode) {
            //Acción de la cámara
            REQUEST_CAMARA -> {
                val imageBitmap = data?.extras!!.get("data") as Bitmap
                imageView.setImageBitmap(imageBitmap)
            }
            //Acción de la suma
            REQUEST_SUMA -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    //Comprobar resultado de la suma
                    var resultado1 = data.getIntExtra("suma", 0).toString()
                    if (resultado1.toInt() == (random + random2)) {
                        textView.text = "Bien " + data.getIntExtra("suma", 0).toString()
                    } else {
                        textView.text = "Mal " + data.getIntExtra("suma", 0).toString()
                    }
                }; }
        }
    }

    companion object {
        //Constantes de las acciones
        const val REQUEST_CAMARA = 1
        const val REQUEST_SUMA = 2

    }
}