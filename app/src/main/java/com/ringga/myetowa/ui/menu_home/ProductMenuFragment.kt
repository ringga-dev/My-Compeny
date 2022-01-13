package com.ringga.myetowa.ui.menu_home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.ringga.myetowa.R
import com.ringga.myetowa.databinding.FragmentProductMenuBinding
import com.ringga.myetowa.ui.menu_home.product.ProductActivity


class ProductMenuFragment : Fragment() {
    private var scaledown: Animation? = null
    companion object {
        fun newInstance()=  ProductMenuFragment()
    }

    private var _binding: FragmentProductMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        scaledown = AnimationUtils.loadAnimation(
            requireContext(),
            R.anim.scale_down_button
        )

        binding.btnOrder.setOnClickListener {
            val chage = Intent(requireContext(), ProductActivity::class.java)
            chage.putExtra("fragment", "order")
            startActivity(chage)
        }

        binding.btnApproved.setOnClickListener {
            val chage = Intent(requireContext(), ProductActivity::class.java)
            chage.putExtra("fragment", "approved")
            startActivity(chage)
        }

        binding.btnReject.setOnClickListener {
            val chage = Intent(requireContext(), ProductActivity::class.java)
            chage.putExtra("fragment", "reject")
            startActivity(chage)
        }
        binding.btnOrdering.setOnClickListener {
            val chage = Intent(requireContext(), ProductActivity::class.java)
            chage.putExtra("fragment", "ordering")
            startActivity(chage)
        }

        binding.btnTake.setOnClickListener {
            val chage = Intent(requireContext(), ProductActivity::class.java)
            chage.putExtra("fragment", "take")
            startActivity(chage)
        }
        binding.btnSucces.setOnClickListener {
            val chage = Intent(requireContext(), ProductActivity::class.java)
            chage.putExtra("fragment", "orderSuccess")
            startActivity(chage)
        }
    }
}