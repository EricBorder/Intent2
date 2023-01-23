package com.example.intent2


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // Variable para escribir el resultado de la suma
        val resultado = findViewById<TextView>(R.id.resultado)
        // Recoge el Intent que ha iniciado la actividad
        val intent = intent
        // Recogemos el Intent que inicia la actividad y extraemos el String
        val message = intent.getIntExtra("NUMERO", 7)
        val message2 = intent.getIntExtra("NUMERO2", 7)

        // Capturamos los textView del Layout y ponemos los Strings como texto
        val textView = findViewById<TextView>(R.id.numero1)
        val textView2 = findViewById<TextView>(R.id.numero2)
        textView.text = message.toString()
        textView2.text = message2.toString()

        // Variable para iniciar la suma
        val botonsuma = findViewById<Button>(R.id.sumar)

        // Escuchador del boton para realizar la suma
        botonsuma.setOnClickListener {
            // Datos adicionales al intent
            intent.putExtra("suma", Integer.valueOf(resultado.text.toString()))
            Log.d("mensaje", "actualizado")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}