package com.mobile.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Poema : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poema)

        // Encontre o botão pelo ID
        val botaoHome = findViewById<Button>(R.id.poema_botaoHome)

        // Defina um ouvinte de clique para o botão
        botaoHome.setOnClickListener {
            // Chame o método finish() para encerrar a atividade
            finish()
        }
    }
}
