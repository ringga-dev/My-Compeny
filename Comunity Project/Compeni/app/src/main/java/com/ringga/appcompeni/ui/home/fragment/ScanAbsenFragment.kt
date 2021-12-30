package com.ringga.appcompeni.ui.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.appcompeni.databinding.FragmentScanAbsenBinding


class ScanAbsenFragment : Fragment() {

    private var _binding: FragmentScanAbsenBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ScanAbsenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScanAbsenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}