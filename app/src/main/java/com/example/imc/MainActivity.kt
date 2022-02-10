package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        val resultado = findViewById<TextView>(R.id.resultado)

        calcular.setOnClickListener {
            val valor1 = findViewById<EditText>(R.id.valor1).text.toString().toDouble()
            val valor2 = findViewById<EditText>(R.id.valor2).text.toString().toDouble()

            val imc = valor1 / (valor2 * valor2)

            resultado.text = imc.toString()


        }

    }
}