package com.ringga.karyawan.ui.auth.fragmen

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ringga.karyawan.R
import com.ringga.karyawan.databinding.FragmentLoginBinding
import com.ringga.karyawan.ui.home.HomeActivity
import com.ringga.karyawan.ui.viewModel.AuthViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.register.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, RegisterFragment.newInstance()).commit()
        }

        binding.lupa.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, LupaPasswordFragment.newInstance()).commit()
        }

        binding.login.setOnClickListener {
            startActivity(Intent(context, HomeActivity::class.java))
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        // TODO: Use the ViewModel
    }

}