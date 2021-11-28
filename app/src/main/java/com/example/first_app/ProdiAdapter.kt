package com.example.first_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation

class ProdiAdapter(
    val listProdi: List<Prodi>,
    val onClickListener: (Prodi) -> Unit
) :
    RecyclerView.Adapter<ProdiAdapter.ProdiViewHolder>() {

    inner class ProdiViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNamaProdi = itemView.findViewById<TextView>(R.id.tv_nama_prodi)
        val ivFotoProdi = itemView.findViewById<ImageView>(R.id.iv_foto)

        fun bind(prodi: Prodi) {
            tvNamaProdi.text = prodi.nama
            ivFotoProdi.load(prodi.foto) {
                transformations(CircleCropTransformation())
            }

            itemView.setOnClickListener {onClickListener(prodi)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_prodi, parent, false)
        return ProdiViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdiViewHolder, position: Int) {
        holder.bind(listProdi[position])
    }

    override fun getItemCount(): Int = listProdi.size

    }