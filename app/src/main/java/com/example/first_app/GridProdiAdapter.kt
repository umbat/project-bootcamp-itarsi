package com.example.first_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridProdiAdapter(
    val listProdi: ArrayList<Prodi>) :
    RecyclerView.Adapter<GridProdiAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.grid_prodi, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val prodi = listProdi[position]

        Glide.with(holder.itemView.context)
            .load(listProdi[position].logoprodi)
            .apply(RequestOptions().override(250,250))
            .into(holder.ivGrid)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listProdi[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listProdi.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivGrid: ImageView = itemView.findViewById(R.id.iv_grid)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Prodi)
    }
}