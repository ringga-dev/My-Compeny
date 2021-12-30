package com.ringga.myetowa.ui.auth.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

//    private lateinit var viewModel: AuthViewModel
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)


    }

}