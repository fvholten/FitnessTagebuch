package com.finnvonholten.fitnesstagebuch

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.internal.LinkedTreeMap
import java.io.BufferedReader
import java.io.InputStreamReader


class UebungenParser(private val context: Context) {

    private val jsonArrayList = (Gson().fromJson(BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.uebungen_data))), Any::class.java) as ArrayList<*>)

    fun countJsonElements(): Int {
        return jsonArrayList.size
    }

    fun putDifficulty(position: Int, textView: TextView) {
        textView.text = (jsonArrayList[position] as LinkedTreeMap<*, *>)["schwierigkeit"].toString()
    }

    fun putImage(position: Int, imageView: ImageView) {
        val imgName = (jsonArrayList[position] as LinkedTreeMap<*, *>)["bild"].toString()
        imageView.setImageResource(context.resources.getIdentifier(imgName.substring(0, imgName.length - 4), "drawable", context.packageName))
    }

    fun putUebung(position: Int, textView: TextView) {
        textView.text = (jsonArrayList[position] as LinkedTreeMap<*, *>)["übung"].toString()
    }

    fun putGeraet(positionParent: Int, positionChild: Int, geraeteTextView: TextView) {
        when {
            ((jsonArrayList[positionParent] as LinkedTreeMap<*, *>)["gerät 1"] != null) and (positionChild == 0) -> geraeteTextView.text = (jsonArrayList[positionParent] as LinkedTreeMap<*, *>)["gerät 1"].toString()
            ((jsonArrayList[positionParent] as LinkedTreeMap<*, *>)["gerät 2"] != null) and (positionChild == 1) -> geraeteTextView.text = (jsonArrayList[positionParent] as LinkedTreeMap<*, *>)["gerät 2"].toString()
            else -> geraeteTextView.text = "-"
        }
    }

    fun geraeteCounter(position: Int): Int {
        var countGeraet = 0
        if ((jsonArrayList[position] as LinkedTreeMap<*, *>)["gerät 1"] != null) countGeraet++
        if ((jsonArrayList[position] as LinkedTreeMap<*, *>)["gerät 2"] != null) countGeraet++
        return countGeraet
    }
}