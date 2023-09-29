package com.mobile.mobileapp.telas.poema.fragments.listaCompras

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.mobile.mobileapp.databinding.FragmentItemcompraBinding

// Importar o Data Binding do Fragmento.
import com.mobile.mobileapp.telas.poema.fragments.listaCompras.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ListComprasRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<ListComprasRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Inflar o layout do item do fragmento e vincular as vistas para popular os dados.
        return ViewHolder(
            FragmentItemcompraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    // Classe ViewHolder usada para manter as vistas do item da lista e vincular os dados.
    inner class ViewHolder(binding: FragmentItemcompraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}