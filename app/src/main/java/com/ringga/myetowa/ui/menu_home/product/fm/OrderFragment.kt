package com.ringga.myetowa.ui.menu_home.product.fm

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ringga.myetowa.R
import com.ringga.myetowa.data.adapter.ListOrderUserAdapter
import com.ringga.myetowa.databinding.FragmentOrderBinding
import com.ringga.myetowa.ui.menu_home.UserHomeState
import com.ringga.myetowa.ui.menu_home.UserHomeViewModel
import com.ringga.myetowa.ui.menu_home.product.ProductDetailActivity
import com.ringga.security.util.toast


class OrderFragment : Fragment() {
    companion object {
        fun newInstance() = OrderFragment()
    }
    private lateinit var userViewModel: UserHomeViewModel
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userViewModel = ViewModelProviders.of(this).get(UserHomeViewModel::class.java)
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userViewModel.getOrderUser(requireContext(),"order")
        binding.openNewOrder.setOnClickListener {
            showCustomAlert()
        }

        binding.root.setOnClickListener {
            activity?.startActivity(Intent(requireContext(), ProductDetailActivity::class.java))
        }

        setupRecler()

//        binding.tvName
        userViewModel.getState().observer(this, Observer {
            handleUiState(it)
        })


    }


    private fun handleUiState(it: UserHomeState) {
        when (it) {
            is UserHomeState.Error -> {
//                isloding(false)
                toast(requireContext(), it.err)
            }
            is UserHomeState.ShoewToals -> toast(requireContext(), it.message)
            is UserHomeState.Failed -> {
//                isloding(false)
                toast(requireContext(), it.message)
            }

            is UserHomeState.userData -> {

            }
            is UserHomeState.userOrder ->{
                binding.ivOrder.adapter?.let { adapter ->
                    if (adapter is ListOrderUserAdapter) {
                        adapter.setLagu(it.data.data)
                    }
                }
            }
//            is UserState.IsLoding -> isloding(it.state)
        }
    }

    private fun setupRecler() {
        binding.ivOrder.apply {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = ListOrderUserAdapter(mutableListOf(), requireContext(), requireFragmentManager())

        }
    }




    private fun showCustomAlert() {

        val inflate = layoutInflater
        val infla_view = inflate.inflate(R.layout.alert_order, null)
        val jadwal_visitor = infla_view.findViewById<CardView>(R.id.btn_jadwal_visitor)
        val daftar_visitor = infla_view.findViewById<CardView>(R.id.btn_daftar_visitor)
        val visitor_now = infla_view.findViewById<CardView>(R.id.btn_visitor_now)

        val cencel = infla_view.findViewById<ImageView>(R.id.btn_cencel)
        jadwal_visitor.setOnClickListener {
//            startActivity(Intent(this, DaftarVisitorPlanActivity::class.java))
        }

        daftar_visitor.setOnClickListener {
//            startActivity(Intent(this, DaftarVisitorActivity::class.java))
        }

        visitor_now.setOnClickListener {
//            startActivity(Intent(this, DaftarVisitorBerjalanActivity::class.java))
        }

        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setView(infla_view)
        alertDialog.setCancelable(false)


        val dialog = alertDialog.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        cencel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }
}