package com.ringga.karyawan.ui.auth.fragmen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ringga.karyawan.R
import com.ringga.karyawan.databinding.FragmentLupaPasswordBinding
import com.ringga.karyawan.databinding.FragmentRegisterBinding
import com.ringga.karyawan.ui.viewModel.AuthViewModel


class LupaPasswordFragment : Fragment() {
    private var _binding: FragmentLupaPasswordBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = LupaPasswordFragment()
    }

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLupaPasswordBinding.inflate(inflater, container, false)
        val view = binding.root

//        binding.login.setOnClickListener {
//            requireFragmentManager().beginTransaction()
//                .replace(R.id.container, LoginFragment()).commit()
//        }


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        // TODO: Use the ViewModel
    }

}