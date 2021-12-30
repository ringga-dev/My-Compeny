package com.ringga.karyawan.ui.home.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ringga.karyawan.databinding.FragmentDashboardBinding
import com.ringga.karyawan.pekerjaan.snackbar
import com.ringga.karyawan.pekerjaan.toals
import com.ringga.karyawan.ui.lingkungan.CuacaActivity
import com.ringga.karyawan.ui.scan.AbsensiActivity
import com.ringga.karyawan.ui.viewModel.HomeViewModel


class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = DashboardFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.tombolSatu.setOnClickListener {
            startActivity(Intent(context, AbsensiActivity::class.java))
        }

        binding.cuaca.setOnClickListener {
            startActivity(Intent(context, CuacaActivity::class.java))
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun klik() {
        Toast.makeText(context, "text", Toast.LENGTH_LONG).show()
    }
}