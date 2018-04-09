package com.finnvonholten.fitnesstagebuch

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class UebungenAdapter(context: Context) :
        RecyclerView.Adapter<UebungenAdapter.ViewHolder>() {

    private val uebungParser = UebungenParser(context, getUebungenData(context))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UebungenAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.uebungen_recylerview_item, parent, false)
        val infoButton: ImageButton = view.findViewById(R.id.infoButton)
        val uebungsName: TextView = view.findViewById(R.id.uebungsName)
        val difficulty: TextView = view.findViewById(R.id.difficulty)
        val muskelImg: ImageView = view.findViewById(R.id.muskelimg)
        val geraeteRecyclerView: RecyclerView = view.findViewById(R.id.geraeteRecyclerView)

        return ViewHolder(infoButton, uebungsName, difficulty, muskelImg, geraeteRecyclerView, view)
    }

    override fun getItemCount(): Int {
        return uebungParser.countJsonElements()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        uebungParser.putDifficulty(position, holder.difficulty)
        uebungParser.putImage(position, holder.muskelImg)
        uebungParser.putUebung(position, holder.uebungsName)


        holder.geraeteRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = GeraeteAdapter(uebungParser, position)

        }
    }

    private fun getUebungenData(context: Context): ArrayList<*> {
        return Gson().fromJson(BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.uebungen_data))), Any::class.java) as ArrayList<*>
    }

    class ViewHolder(val infoButton: ImageButton, val uebungsName: TextView, val difficulty: TextView, val muskelImg: ImageView, val geraeteRecyclerView: RecyclerView, view: View) : RecyclerView.ViewHolder(view)

}