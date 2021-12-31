package com.example.first_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListProdiAdapter(
    private val listProdi: List<Prodi>
) :
    RecyclerView.Adapter<ListProdiAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_prodi, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val prodi = listProdi[position]

        Glide.with(holder.itemView.context)
            .load(prodi.logoprodi)
            .apply(RequestOptions().override(55, 55))
            .into(holder.ivLogoProdi)

        holder.tvNameProdi.text = prodi.nama

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listProdi[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listProdi.size
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivLogoProdi = itemView.findViewById<ImageView>(R.id.iv_prodi)
        val tvNameProdi = itemView.findViewById<TextView>(R.id.tv_nama_prodi)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Prodi)
    }
}
