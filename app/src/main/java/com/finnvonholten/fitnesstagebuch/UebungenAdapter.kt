package com.finnvonholten.fitnesstagebuch

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.apache.commons.text.WordUtils

class UebungenAdapter(private val context: Context) :
        RecyclerView.Adapter<UebungenAdapter.ViewHolder>() {

    private val dialog: Dialog = Dialog(context)
    private val uebungsList: List<Uebung> = JsonGetter(context).get()


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
        return uebungsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.difficulty.text = uebungsList[position].schwierigkeit

        holder.muskelImg.setImageResource(context.resources.getIdentifier(uebungsList[position].bild.substring(0, uebungsList[position].bild.length - 4),
                "drawable", context.packageName))
        holder.uebungsName.text = uebungsList[position].uebung

        holder.geraeteRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TextViewAdapter(uebungsList[position].geraeteList())
        }

        holder.infoButton.setOnClickListener {
            dialogBuilder(position)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun dialogBuilder(position: Int) {

        dialog.setContentView(R.layout.uebung_detail_popup_layout)
        dialog.findViewById<LinearLayout>(R.id.popupLayout).setOnClickListener { dialog.dismiss() }
        dialog.findViewById<TextView>(R.id.popupTitle).text = uebungsList[position].uebung
        dialog.findViewById<ImageView>(R.id.muskelimgPopup).setImageResource(
                context.resources.getIdentifier(uebungsList[position].bild.substring(0, uebungsList[position].bild.length - 4),
                        "drawable", context.packageName))
        dialog.findViewById<TextView>(R.id.muskelPopupContentPopup).text = WordUtils.capitalize(uebungsList[position].muskelgruppe) + " - " + WordUtils.capitalize(uebungsList[position].muskelgruppeDetail, "-"[0])
        dialog.findViewById<TextView>(R.id.difficultyPopup).text = uebungsList[position].schwierigkeit

        dialog.findViewById<RecyclerView>(R.id.mainMuskelRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TextViewAdapter(uebungsList[position].hauptMuskelList())
        }
        dialog.findViewById<RecyclerView>(R.id.subMuskelRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TextViewAdapter(uebungsList[position].nebenMuskelList())
        }
        dialog.findViewById<RecyclerView>(R.id.geraetePopupRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TextViewAdapter(uebungsList[position].geraeteList())
        }
        dialog.show()
    }

    class ViewHolder(val infoButton: ImageButton, val uebungsName: TextView, val difficulty: TextView, val muskelImg: ImageView, val geraeteRecyclerView: RecyclerView, view: View) : RecyclerView.ViewHolder(view)
}