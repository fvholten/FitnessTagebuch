package com.finnvonholten.fitnesstagebuch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class GeraeteAdapter(private val uebungParser: UebungenParser, private val positionParent: Int) :
        RecyclerView.Adapter<GeraeteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeraeteAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.geraete_recylerview_item, parent, false)
        return GeraeteAdapter.ViewHolder(view.findViewById(R.id.geraet), view)
    }

    override fun getItemCount(): Int {
        return uebungParser.geraeteCounter(positionParent)
    }

    override fun onBindViewHolder(holder: GeraeteAdapter.ViewHolder, position: Int) {
        uebungParser.putGeraet(positionParent, position, holder.geraeteTextView)
    }

    class ViewHolder(val geraeteTextView: TextView, view: View) : RecyclerView.ViewHolder(view)
}

