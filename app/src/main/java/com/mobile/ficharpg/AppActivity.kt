package com.mobile.ficharpg

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// Importacoes Google Services
import com.google.firebase.auth.FirebaseAuth

// Importacoes Material3 e Compose
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.ficharpg.ui.theme.AppTheme

// Tela de Selecao de Calculadora
class AppActivity : AppCompatActivity() {
    // Late Init do Firebase p/ Deslogar
    private lateinit var autenticacaoFirebase: FirebaseAuth
    private val currentActivity = this  // Capture a Activity atual em uma variável

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pegar instancia do Firebase com o usuario logado
        autenticacaoFirebase = FirebaseAuth.getInstance()

        // Método: Compose + Material3.
        // Compose: https://developer.android.com/jetpack/compose
        // Material3: https://developer.android.com/codelabs/jetpack-compose-theming
        setContent {
            // Use AppTheme from UI Theme - Compose Material.
            AppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()


                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        EscolherAcao("Calculadora Basica")
                        EscolherAcao("Calculadora Avançada")
                        EscolherAcao("Deslogar", currentActivity)

                    }
                }
            }
        }
    }
}

// Funcoes Compose / Material 3
@Composable
fun EscolherAcao(nomeDaTela: String, currentActivity: Activity? = null) {
    Button(onClick = {
        when (nomeDaTela) {
            "Deslogar" -> {
                // Desloga do Google e Volta para a Tela de Login
                FirebaseAuth.getInstance().signOut()
                currentActivity?.finish()
            }
        }
    }) {
        Text(text = nomeDaTela)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun DefaultPreview() {
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxHeight()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                EscolherAcao("Calculadora Basica")
                EscolherAcao("Calculadora Avançada")
                EscolherAcao("Deslogar")
            }
        }
    }
}