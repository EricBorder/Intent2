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

    var numeros = arrayOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
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
        //es un combobox con varias opciones
        var spinner = findViewById<Spinner>(R.id.spinner)
        // Crea un ArrayAdapter usando un simple spinner layout ay el array de numeros
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, numeros)
        // pone un layout para las opciones que vayan a salir
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asociar el adaptador al spinner
        spinner!!.setAdapter(aa)

        botonsuma.setOnClickListener {
            val numPosition = spinner.selectedItemPosition
            val valornum = numeros[numPosition];
            intent.putExtra("suma",valornum)
            Log.d("mensaje", "actualizado")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}