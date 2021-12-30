package com.example.first_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridAdapter(
    val listProdi: ArrayList<Prodi>) :
    RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.grid_prodi, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listProdi[position].logoprodi)
            .apply(RequestOptions().override(250,250))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listProdi[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listProdi.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_grid)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Prodi)
    }
}