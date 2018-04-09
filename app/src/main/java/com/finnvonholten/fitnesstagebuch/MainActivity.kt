package com.finnvonholten.fitnesstagebuch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        viewAdapter = UebungenAdapter(this)

        recyclerView = findViewById<RecyclerView>(R.id.uebungen_recycler_view).apply {
            layoutManager = viewManager
            layoutManager
            adapter = viewAdapter
        }
    }
}