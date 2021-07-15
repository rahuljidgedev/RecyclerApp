package com.demo.recyclerapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlphaNumericAdapter(private val arrayList:ArrayList<AlphaNumericData>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val typeHeader = 0
    private val typeItem = 1
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == typeHeader) {
            return AlphaNumericHeadingHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.heading_item, parent, false))
        }

        return AlphaNumericItemHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AlphaNumericHeadingHolder) {
            holder.bind(arrayList[position])
        } else {
            (holder as AlphaNumericItemHolder).bind(arrayList[position])
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0 || position == 27)
                typeHeader
            else
                typeItem

    }

    inner class AlphaNumericHeadingHolder(binding: View) : RecyclerView.ViewHolder(binding) {
        var item: TextView = binding.findViewById(R.id.tv_item)
        fun bind(item: AlphaNumericData){
            this.item.text = item.dataString
        }
    }

    inner class AlphaNumericItemHolder(binding: View) : RecyclerView.ViewHolder(binding) {
        var item: TextView = binding.findViewById(R.id.tv_item)
        fun bind(item: AlphaNumericData){
            this.item.text = item.dataString
        }
    }
}