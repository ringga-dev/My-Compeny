package com.ringga.karyawan.ui.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ringga.karyawan.R
import com.ringga.karyawan.databinding.FragmentPopulerBinding
import com.ringga.karyawan.databinding.FragmentProfileBinding
import com.ringga.karyawan.ui.viewModel.HomeViewModel


class PopulerFragment : Fragment() {
    private var _binding: FragmentPopulerBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = PopulerFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopulerBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }
}