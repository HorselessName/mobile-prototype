package com.mobile.mobileapp.telas.poema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.mobile.mobileapp.R

// Importar o Fragmento que eu quero.
import com.mobile.mobileapp.telas.poema.fragments.listaCompras.ListComprasFragment

class PoemaActivity : AppCompatActivity() {
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
        
        // TODO: Adicionar um Fragmento na Activity Poema.
        // Passo 1 - Criar o Objeto Controller do tipo supportFragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager

        // Passo 2 - Abrir um objeto do tipo fragmentManager para usar o método transaction
        val transaction = fragmentManager.beginTransaction()

        // Passo 3 - Adicionar o Fragment ao elemento Viewer desta Activity que você quer o Fragment
        transaction.add(R.id.comprasListFragmentView, ListComprasFragment())

        // Passo 4 - Comitar as alteracoes na atividade usando o método commit do Transaction
        transaction.commit()

        // TODO: https://www.geeksforgeeks.org/how-to-implement-recylerview-in-a-fragment-in-android/

    }
}