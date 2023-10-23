package com.mobile.ficharpg
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity() {

    // Inicializando variáveis para autenticação do Google
    private lateinit var autenticacaoFirebase: FirebaseAuth
    private lateinit var opcoesGoogleSignIn: GoogleSignInOptions
    private lateinit var clienteGoogleSignIn: GoogleSignInClient

    // Registra a atividade de resultado do login Google
    private val iniciadorLoginGoogle = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
        if (resultado.resultCode == Activity.RESULT_OK) {
            // Obtem o token de identificação
            val credencialToken = GoogleSignIn.getSignedInAccountFromIntent(resultado.data).result?.idToken
            val autenticacao = FirebaseAuth.getInstance()
            // Cria credencial para autenticação no Firebase
            val credencialGoogle = GoogleAuthProvider.getCredential(credencialToken, null)
            autenticacao.signInWithCredential(credencialGoogle).addOnCompleteListener { tarefa ->
                if (tarefa.isSuccessful) {
                    abrirActivityApp()
                } else {
                    // Tratamento de erro
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurações de login Google (ID do cliente obtido no console do Firebase)
        autenticacaoFirebase = FirebaseAuth.getInstance()
        opcoesGoogleSignIn = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()
        clienteGoogleSignIn = GoogleSignIn.getClient(this, opcoesGoogleSignIn)

        // Ação do botão de login
        val botaoLogar = findViewById<Button>(R.id.botaoLogar)
        botaoLogar.setOnClickListener {
            logarComGoogle()
        }
    }

    // Inicia a tentativa de login com o Google
    private fun logarComGoogle() {
        val intentLoginGoogle = clienteGoogleSignIn.signInIntent
        iniciadorLoginGoogle.launch(intentLoginGoogle)
    }

    // Abre a nova atividade após login bem-sucedido
    private fun abrirActivityApp() {
        val intent = Intent(this, AppActivity::class.java)
        startActivity(intent)
    }
}
