package com.mobile.mobileapp.telas.poema.fragments.listaCompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.mobileapp.R
import com.mobile.mobileapp.models.Item

/**
 * Class: [ComprasListAdapter]
 * Type: [RecyclerView.Adapter] of Type <ComprasListAdapter.ViewHolder>.
 * Methods:
 * [ComprasListAdapter.onCreateViewHolder]
 * [ComprasListAdapter.onBindViewHolder]
 * [ComprasListAdapter.getItemCount]
 * [ComprasListAdapter.ViewHolder]
 *
 * O RecyclerView.Adapter é uma classe abstrata que fornece a implementação base para gerar
 * e gerenciar os views de cada dado que irá ser exibido dentro do RecyclerView.
 *
 * Aqui recebemos o dataset do RecyclerView no Adapter "Lista de Compras" e o Context via
 * construtor para poder usar o LayoutManager no Fragmento.
 *
 * TODO: Classe, Documentação da Classe, Métodos e Documentação dos Métodos.
 */
class ComprasListAdapter(
    private val dataset: MutableList<Item>, private val context: Context
) : RecyclerView.Adapter<ComprasListAdapter.ViewHolder>() {

    // Cria novas visualizações (invocadas pelo layout manager) ao criar ViewHolder de cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Retorna a instância do nosso ViewHolder com o layout do item da lista.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_da_lista_view, parent, false)

        return ViewHolder(view)
    }

    /**
     * O ciclo de vida onBindViewHolder() tem a finalidade de atualizar o conteúdo de cada
     * item da lista com base na posição atual.
     *
     * Para isso, é necessário obter o objeto atual do dataset e definir os valores dos items
     * no ViewHolder, ou seja, as proprieades do item da lista, criado na pasta "models".
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Setar os valores do dataset no ViewHolder para a posição atual.
        val item = dataset[position]

        // Realizar o processo de bind, ou seja, colocar as informações do objeto em
        // cada item da lista.
        holder.nomeItemTextView.text = item.nomeDoItem
        holder.descricaoItemTextView.text = item.descricaoItem
    }

    // Retorna o tamanho do dataset (invocado pelo layout manager)
    override fun getItemCount() = dataset.size

    // ViewHolder: Represents each List Item.
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Puxar as propriedades do item da lista para o ViewHolder.
        val nomeItemTextView: TextView = view.findViewById(R.id.nome_item)
        val descricaoItemTextView: TextView = view.findViewById(R.id.descricao_item)
    }
}