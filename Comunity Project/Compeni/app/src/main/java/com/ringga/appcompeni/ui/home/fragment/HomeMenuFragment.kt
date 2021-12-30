package com.ringga.appcompeni.ui.home.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.ringga.appcompeni.R
import com.ringga.appcompeni.databinding.FragmentHomeMenuBinding

class HomeMenuFragment : Fragment() {
    private var _binding: FragmentHomeMenuBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = HomeMenuFragment()
    }

    //TODO: private lateinit var viewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        // TODO: Use the ViewModel
        binding.btnAbsen.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, ScanAbsenFragment.newInstance()).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}