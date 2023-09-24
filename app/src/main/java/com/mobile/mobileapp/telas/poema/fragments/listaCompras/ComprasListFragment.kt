package com.mobile.mobileapp.telas.poema.fragments.listaCompras

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.mobileapp.R
import com.mobile.mobileapp.models.Item

/**
 * Class: [ComprasListFragment]
 * @constructor: [Fragment] - Creates a Fragment Component.
 *
 * Methods:
 *
 * [ComprasListFragment.onCreate]
 * @param: Bundle
 *
 * Ao criar o fragmento, você deve puxar o widget RecyclerView do layout do fragmento e
 * usar o LayoutManager para popular a lista com o conjunto de dados.
 *
 * [ComprasListFragment.onCreateView]
 * @constructor: [View]
 * @param LayoutInflater
 * @param ViewGroup
 * @param Bundle
 *
 * Essa classe que possui o RecyclerView precisa do adapter implementado, que é a classe
 * [ComprasListAdapter], para poder popular o RecyclerView com o dataset.
 *
 * TODO: Classe, Documentação da Classe, Métodos e Documentação dos Métodos.
 */

class ComprasListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataSet do RecyclerView no Adapter "Lista de Compras".
        val listadefrutas = mutableListOf(
            Item(0, "Batata", "Batata é um tubérculo."),
            Item(1, "Abacate", "Abacate é uma fruta."),
            Item(2, "Cenoura", "Cenoura é uma raiz."),
            Item(3, "Cebola", "Cebola é um bulbo."),
        )

        // Buscar o RecyclerView do layout do fragmento e settar o nosso Adapter.
        val recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_ComprasList)
        recyclerView?.adapter = ComprasListAdapter(listadefrutas, requireContext())

        // O comando acima, no seu segundo argumento `requireContext()`, trás o objeto
        // Contexto deste Fragmento, ou seja, é o mesmo que fazer em versões mais antigas do
        // Android, o seguinte:
        // `recyclerView.adapter = RecyclerAdapter(datasetDeAlgo, this)`

        // Agora precisamos apenas indicar o layout do RecyclerView por meio do LayoutManager.
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreateView(
        // Injetar o estilo no componente.
        inflater: LayoutInflater,

        // Funcionalidade básica para agrupar várias Views
        container: ViewGroup?,

        // Salvar status do fragmento para restaurar a interface do usuário.
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment (Has a ReciclerView Widget)
        return inflater.inflate(R.layout.fragment_lista_de_compras, container, false)
    }
}
