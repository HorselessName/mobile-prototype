package com.mobile.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mobile.mobileapp.models.Item

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

        // Definir meu DataSet pra ser renderizado pelo RecicleView (Gerador de Listas)
        var listadefrutas = mutableListOf(
            Item("Batata"),
            Item("Abacate"),
            Item("Cenoura"),
            Item("Cebola")
        )

    }
}
