package com.mobile.mobileapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Our First screen.
 * It presents us with a Login Screen.
 * You will only be directed to the Home Activity if authentication succeeds.
 *
 * @param none The main activity takes no parameters
 * @property none Our main activity has no properties
 * @constructor It creates and renders our layout with it's functions
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Renders Home activity if authenticated
     * It uses Intent class, which is a abstract class that can be used
     * to render other activies and talk with other components.
     *
     * @return It does not return anything
     */
    fun acessarTelaInicial(nomeUsuario : String){
        val telaInicial: Intent = Intent(this, Home::class.java)

        // https://developer.android.com/reference/kotlin/android/content/Intent#putextra_8
        telaInicial.putExtra("nomeUsuario", nomeUsuario)
        startActivity(telaInicial)
    }

    /**
     * Has logic that gets EditText type classes which contains Login/Passwords
     * inputs from user and validates it's authentication.
     * If auth passes, sends user to Home Page activity.
     *
     * @return It does not return anything
     */
    fun fazerLogin(elementoLogin: View){
        // Referencias das Views
        val editTextUsername: EditText = findViewById(R.id.editTextUsername)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        val textViewErros: TextView = findViewById(R.id.textViewErros)

        // Lógica de Validação de Senha
        val username = editTextUsername.text.toString()
        if (username == "admin"){
            if (editTextPassword.text.toString() == "123") {
                acessarTelaInicial(username)
                finish()
            }
            else{
                textViewErros.text = getString(R.string.login_invalidpassword)
            }
        }
        else{
            textViewErros.text = getString(R.string.login_invalidlogin)
        }
    }
}