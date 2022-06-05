package com.example.college.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.college.R
import com.example.college.dataClass.RecyclerViewdata
import com.example.college.testModel.Values
import com.example.college.testModel.test
import com.google.android.material.imageview.ShapeableImageView

class recyclerViewAdapter(private val viewlist:ArrayList<RecyclerViewdata>):RecyclerView.Adapter<recyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val profile_image:ShapeableImageView = itemView.findViewById(R.id.profile_image)
        val dept_name:TextView = itemView.findViewById(R.id.dept_name)
        val post_text:TextView = itemView.findViewById(R.id.tv_of_post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_listview_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = viewlist[position]
        holder.profile_image.setImageResource(currentItem.profile)
        holder.dept_name.text = currentItem.dept
        holder.post_text.text = currentItem.text_of_post
    }

    override fun getItemCount(): Int {
        return viewlist.size
        test.value = Values(viewlist.size)
    }

}