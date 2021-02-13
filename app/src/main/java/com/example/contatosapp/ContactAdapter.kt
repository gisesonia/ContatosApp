package com.example.contatosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Tipo do Adapter é a inner class. Gerencia a lista
class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val lista: MutableList<Contact> = mutableListOf()

    //cria o container da view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        //instanciação do viewholder
        return ContactAdapterViewHolder(view, lista, listener)
    }

    //preenche a lista
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        //posição do item
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
       return lista.size
    }

    fun updateListAdapter(lista: List<Contact>) {
        this.lista.clear()
        this.lista.addAll(lista)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(itemView:View, var lista: List<Contact>, var listener: ClickItemContactListener) :
        RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_namedetail)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phonedetail)
        private val ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photodetail)

        //chama um método da interface
        init {
            itemView.setOnClickListener {
                listener.clickItemContact(lista[adapterPosition])
            }
        }

        fun bind(contact: Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }
}