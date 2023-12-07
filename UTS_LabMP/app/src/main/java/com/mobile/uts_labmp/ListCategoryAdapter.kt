package com.mobile.uts_labmp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCategoryAdapter(private val listCategory: ArrayList<Category>) : RecyclerView.Adapter<ListCategoryAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.item_img)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_category, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCategory.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (image, name) = listCategory[position]
        holder.imgPhoto.setImageResource(image)
        holder.tvName.text = name
    }

}