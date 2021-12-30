package com.ringga.karyawan.data.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ringga.karyawan.R
import com.ringga.karyawan.data.response.ResponCuaca
import kotlinx.android.synthetic.main.item_cuaca.view.*

class CuacaAdapter(
    private var wallpaper: MutableList<ResponCuaca>,
    private var context: Context
) : RecyclerView.Adapter<CuacaAdapter.ViewHolder>() {

    fun setWallpapers(r: List<ResponCuaca>) {
        wallpaper.clear()
        wallpaper.addAll(r)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cuaca, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(wallpaper[position], context)

    override fun getItemCount() = wallpaper.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(wallpaper: ResponCuaca, context: Context) {

            itemView.kota.text = "Kota : ${wallpaper.kota}"
            itemView.pagi.text = "Pagi : ${wallpaper.pagi}"
            itemView.siang.text ="Siang : ${wallpaper.siang}"
            itemView.malam.text = "Malam ${wallpaper.malam}"
            itemView.dini_hari.text ="Dini Hari : ${wallpaper.dini_hari}"
            itemView.suhu.text ="Suhu : ${wallpaper.suhu}"
            itemView.kelembaban.text ="Kelembaban : ${wallpaper.kelembaban}"
        }
    }
}