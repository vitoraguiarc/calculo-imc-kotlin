package com.example.imc

    fun calcularImc(peso: Double, altura: Double): Double {
        return peso / (altura * altura)

    }

    fun validarImc(imc: Double): String {
        if (imc <= 18.5) {
            return ("Você está abaixo do peso")
        } else if (imc <= 24.9) {
            return ("Parabéns, você está com o peso ideal")
        } else if (imc <= 29.9) {
            return ("Você está com sobrepeso")
        } else if (imc <= 34.9) {
            return ("Você está com obesidade grau I")
        } else if (imc <= 39.9) {
            return ("Você está com obesidade grau II")
        } else {
            return ("Você está com obesidade grau III")
        }
    }
