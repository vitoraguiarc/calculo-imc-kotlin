package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

//variavies da função
private lateinit var valor1EditText: EditText
private lateinit var valor2EditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dec = DecimalFormat("#,##")
        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)
        val resultado = findViewById<TextView>(R.id.resultado)

        calcular.setOnClickListener {
            valor1EditText = findViewById(R.id.valor1)
            valor2EditText = findViewById(R.id.valor2)


            if (validarCampos()) {
                val peso = valor1EditText.text.toString().toDouble()
                val altura = valor2EditText.text.toString().toDouble()

                val imc = calcularImc(peso, altura)

                resultado.text = validarImc(imc) + "\nSeu peso: ${dec.format(imc)}"
            }

        }

        //botão sair
        sair.setOnClickListener {
            finish()
        }

    }


    private fun validarCampos(): Boolean { //Validando os campos
        var noError = true
        if (valor1EditText.text.isBlank()) {
            valor1EditText.setError("Por favor digite seu peso") //Mensagem de erro para o usuario
            noError = false
        }
        if (valor2EditText.text.isBlank()) {
            valor2EditText.setError("Por favor digite sua altura")
            noError = false
        }

        return noError
    }
}