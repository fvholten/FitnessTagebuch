package com.finnvonholten.fitnesstagebuch

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader

class UebungenParser(context: Context) {

    private val jsonReader: JsonReader = JsonReader(InputStreamReader(context.resources.openRawResource(R.raw.uebungen_data)))

    fun putDifficulty(position: Int, textView: TextView) {
        //val jsonObject: JsonObject = Gson().fromJson(jsonReader, JsonObject.class)
        textView.text = "blub blub bla"
    }

    fun putImage(position: Int, imageView: ImageView) {
        imageView.setImageResource(R.drawable.ohne)
    }

    fun putUebung(position: Int, textView: TextView) {
        textView.text = "geile übung"
    }
}