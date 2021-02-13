package com.example.contatosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    //Pede a interface que já está sendo Implementada que é o this (ClickItemContactListener)
    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updateList()
    }

    private fun bindViews() {
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateListAdapter(
            arrayListOf(
                Contact(
                    "Gilberto Souza",
                    "(00) 0000-00000",
                    "img.png"
                ),
                Contact(
                    "Antonio da Silva",
                    "(00) 0000-00000",
                    "img.png"
                )
            )
        )
}

    //Implementa interface ClickItemContactListener
    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetailActivity::class.java)
        startActivity(intent)
    }


}