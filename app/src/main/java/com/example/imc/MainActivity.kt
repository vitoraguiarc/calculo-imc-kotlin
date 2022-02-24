package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

//variavies da função
private lateinit var valor1EditText: EditText
private lateinit var valor2EditText: EditText
private lateinit var nomeEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dec = DecimalFormat("#.##")
        //val decImc = DecimalFormat ("##, #")
        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener {
            valor1EditText = findViewById(R.id.valor1)
            valor2EditText = findViewById(R.id.valor2)
            nomeEditText = findViewById(R.id.nome)

            if (validarCampos()) {

                val peso = valor1EditText.text.toString().toDouble()
                val altura = valor2EditText.text.toString().toDouble()

                val imc = calcularImc(peso, altura)

                //resultado.text = validarImc(imc) + "\nSeu peso: ${dec.format(imc)}"

                val intent = Intent(this, ActivityRelatorio::class.java)

                //Area de transfrencia para a outra pagina
                intent.putExtra("nome", nomeEditText.text.toString())
                intent.putExtra("peso", "${peso}")
                intent.putExtra("altura", "${altura}")
                intent.putExtra("status", validarImc(imc))
                intent.putExtra("imc", "${dec.format(imc)}")

                startActivity(intent)
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
        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("Por favor digite seu nome")
            noError = false
        }

        return noError
    }
}