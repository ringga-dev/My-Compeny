package com.ringga.myetowa.data.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ringga.myetowa.R
import com.ringga.myetowa.data.model.OrderUser
import com.ringga.myetowa.databinding.ItemViewOrderBinding
import java.text.NumberFormat
import java.util.*


class ListOrderUserAdapter(
    private var lagus: MutableList<OrderUser>,
    private var context: Context,
    private var supportFragmentManager: FragmentManager,
) : RecyclerView.Adapter<ListOrderUserAdapter.PageHolder>() {

    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemViewOrderBinding.bind(view)

    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        with(holder) {
            binding.ivImage.load("https://picsum.photos/200/300") {
                allowHardware(false)
            }


            val localeID =  Locale("in", "ID")
            val numberFormat = NumberFormat.getCurrencyInstance(localeID)
            binding.tvDec.text = lagus[position].dec
            binding.tvHarga.text = numberFormat.format(lagus[position].harga).toString()
            binding.tvQty.text = "QTY : ${lagus[position].qty}"
            binding.tvNameProduc.text = lagus[position].name_produc
            binding.tvStts.text = lagus[position].stts

            if (lagus[position].stts == "order") {
                binding.cvItemOrder.setCardBackgroundColor(Color.parseColor("#CE18D1FF"))
            } else if (lagus[position].stts == "approved") {
                binding.cvItemOrder.setCardBackgroundColor(Color.parseColor("#D801A645"))
            } else if (lagus[position].stts == "reject") {
                binding.cvItemOrder.setCardBackgroundColor(Color.parseColor("#E6FF0000"))
            } else if (lagus[position].stts == "ordering") {
                binding.cvItemOrder.setCardBackgroundColor(Color.parseColor("#63FF00"))
            } else if (lagus[position].stts == "take") {
                binding.cvItemOrder.setCardBackgroundColor(Color.YELLOW)
            }else if (lagus[position].stts == "success") {
                binding.cvItemOrder.setCardBackgroundColor(Color.GREEN)
            }

//            binding.pilih.setOnClickListener {
//                val data = SharedPrefManager.getInstance(context)!!.user
//                RetrofitClient.instance.pemilihan(data.id.toString(), lagus[position].urutan)
//                    .enqueue(object : Callback<BaseResponData> {
//                        override fun onResponse(
//                            call: Call<BaseResponData>,
//                            response: Response<BaseResponData>,
//                        ) {
//                            Toast.makeText(context, response.body()?.msg, Toast.LENGTH_SHORT).show()
//                        }
//
//                        override fun onFailure(call: Call<BaseResponData>, t: Throwable) {
//                            Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
//                        }
//
//                    })
//            }
        }
    }

    fun setLagu(r: List<OrderUser>) {
        lagus.clear()
        lagus.addAll(r)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_view_order, parent, false)
        )
    }

    override fun getItemCount() = lagus.size
}