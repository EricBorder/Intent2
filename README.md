<h1>Tarea Intent2</h1>
En esta tarea, hemos hecho una aplicación para practicar con distintos tipos de Intents. En este caso, hemos realizado un Intent para abrir la cámara,
sacar una foto y que esa misma foto nos la muestre en la pantalla principal y otro Intent para realizar una suma de dos números aleatorios, escribir el resultado
de esa suma y comprobar que el resultado es correcto, devolviendo la comprobación a la pantalla principal.

A continuación podemos ver como es la pantalla principal de esta aplicación:

![1](https://user-images.githubusercontent.com/113973157/214017108-f3934bc8-eb8f-43bb-afa6-0226bef052ad.png)

Añado un ejemplo simple de código para el Intent de la cámara:
```
 REQUEST_CAMARA -> {
                val imageBitmap = data?.extras!!.get("data") as Bitmap
                imageView.setImageBitmap(imageBitmap)
            }
```
            
Así se vería después de sacar una foto en la cámara al usar el botón de la cámara, la pantalla principal:

![2](https://user-images.githubusercontent.com/113973157/214017429-832f45c7-9e21-47fe-af58-cbf3cd12177d.png)

En el caso de la suma, se ha realizado poniendo dos TextView que recogen dos números aleatorios y poniendo un tercer TextView editable, para escribir el resultado
de la suma de esos dos números aleatorios y con un botón de comprobación de la suma. Dicho botón nos devolverá a la pantalla principal donde nos comprobará si el resultado 
es correcto o no.

Añado un ejemplo simple de código para el Intent de la suma y su posterior comprobación en la pantalla principal:
```
 val textView = findViewById<TextView>(R.id.numero1)
        val textView2 = findViewById<TextView>(R.id.numero2)
        textView.text = message.toString()
        textView2.text = message2.toString()
        
        val botonsuma = findViewById<Button>(R.id.sumar)

        botonsuma.setOnClickListener {
            intent.putExtra("suma", Integer.valueOf(resultado.text.toString()))
            Log.d("mensaje", "actualizado")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
```

```
REQUEST_SUMA -> {
                if (data != null) {
                    Log.d("asd", "recibido")
                    var resultado1 = data.getIntExtra("suma", 0).toString()
                    if (resultado1.toInt() == (random + random2)) {
                        textView.text = "Bien " + data.getIntExtra("suma", 0).toString()
                    } else {
                        textView.text = "Mal " + data.getIntExtra("suma", 0).toString()
                    }
                }; }
```

Así se vería la segunda pantalla y el resultado en la pantalla principal:

![3](https://user-images.githubusercontent.com/113973157/214018171-a61285c7-353b-4293-8777-79bcd67f1709.png)
![4](https://user-images.githubusercontent.com/113973157/214018188-6b05ae8f-f95a-4bd9-8fbc-dab19d48694f.png)
