package com.mobile.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    private var usuarioEstaLogado = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Encontre o botão pelo ID
        val botaoLerPoema = findViewById<Button>(R.id.botao_lerPoema)

        // Defina um ouvinte de clique para o botão
        botaoLerPoema.setOnClickListener {
            // Crie uma Intent para iniciar a atividade Poema.kt
            val intent = Intent(this, Poema::class.java)

            // Inicie a atividade usando a Intent
            startActivity(intent)
        }
    }
}
