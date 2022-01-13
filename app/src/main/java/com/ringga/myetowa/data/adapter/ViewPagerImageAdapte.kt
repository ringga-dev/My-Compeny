package com.ringga.myetowa.data.adapter

import android.content.Context
import android.widget.LinearLayout

import android.view.ViewGroup


import android.view.LayoutInflater
import android.view.View

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ringga.myetowa.R
import com.ringga.myetowa.databinding.ItemImageViewBinding


internal class ViewPagerImageAdapte(
    private val ctx: Context,
    private var images: MutableList<String>,
) : RecyclerView.Adapter<ViewPagerImageAdapte.PageHolder>() {


    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemImageViewBinding.bind(view)
//        ViewBinding.inflate(inflater, parent, false)

    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        with(holder) {
            binding.imageViewMain.load(images[position])
        }
    }

    fun setLagu(r: List<String>) {
        images.clear()
        images.addAll(r)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
      val view:View = LayoutInflater.from(ctx).inflate(R.layout.item_image_view, parent, false)
          PageHolder(
            LayoutInflater.from(ctx).inflate(R.layout.item_image_view, parent, false)
        )
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        return PageHolder(view)
    }

    override fun getItemCount() = images.size
}