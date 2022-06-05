package com.example.college.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.college.R
import com.example.college.dataClass.HorizontalRecyclerViewdata
import com.example.college.dataClass.RecyclerViewdata
import com.example.college.testModel.Values
import com.example.college.testModel.test
import com.google.android.material.imageview.ShapeableImageView

class HorizontalrecyclerViewAdapter(private val viewlist:ArrayList<HorizontalRecyclerViewdata>):RecyclerView.Adapter<HorizontalrecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val category:TextView = itemView.findViewById(R.id.tv_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.horizontal_recyclerview,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = viewlist[position]
        holder.category.text = currentItem.category
    }

    override fun getItemCount(): Int {
        return viewlist.size
    }

}