package com.finnvonholten.fitnesstagebuch

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TextViewAdapter(private val stringList: List<String>) :
        RecyclerView.Adapter<TextViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recylerview_textitem, parent, false)
        return TextViewAdapter.ViewHolder(view.findViewById(R.id.textView), view)
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    override fun onBindViewHolder(holder: TextViewAdapter.ViewHolder, position: Int) {
        holder.textView.text = stringList[position]
    }

    class ViewHolder(val textView: TextView, view: View) : RecyclerView.ViewHolder(view)
}

