package com.finnvonholten.fitnesstagebuch

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader

class JsonGetter(context: Context) {

    private val uebungsList = Gson().
            fromJson<List<Uebung>>(BufferedReader(InputStreamReader(context.resources.openRawResource(R.raw.uebungen_data))), object : TypeToken<List<Uebung>>(){}.type)

    fun get(): List<Uebung> {
        return uebungsList
    }
}