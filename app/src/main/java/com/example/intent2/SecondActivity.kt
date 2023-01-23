package com.example.intent2


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val resultado = findViewById<TextView>(R.id.resultado)
        // Recoge el Intent que ha iniciado la actividad
        val intent = intent
        // Get the Intent that started this activity and extract the string
        val message = intent.getIntExtra("NUMERO", 7)
        val message2 = intent.getIntExtra("NUMERO2", 7)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.numero1)
        val textView2 = findViewById<TextView>(R.id.numero2)
        textView.text = message.toString()
        textView2.text = message2.toString()

        val botonsuma = findViewById<Button>(R.id.sumar)

        botonsuma.setOnClickListener {
            intent.putExtra("suma",Integer.valueOf(resultado.text.toString()))
            Log.d("mensaje", "actualizado")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}