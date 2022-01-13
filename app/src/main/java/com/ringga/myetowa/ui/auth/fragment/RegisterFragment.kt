package com.ringga.myetowa.ui.auth.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ringga.myetowa.data.utils.*
import com.ringga.myetowa.databinding.FragmentRegisterBinding
import com.ringga.myetowa.ui.auth.AuthActivity
import com.ringga.myetowa.ui.auth.AuthViewModel
import com.ringga.myetowa.ui.auth.UserState
import com.ringga.security.util.toast


class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

//    private lateinit var viewModel: AuthViewModel
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var userViewModel: AuthViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        userViewModel.getState().observer(this, Observer {
            handleUiState(it)
        })

        doRegister()
    }


    private fun handleUiState(it: UserState) {
        when (it) {

            is UserState.Error -> {
//                isloding(false)
                toast(requireContext(),it.err)
            }
            is UserState.ShoewToals -> toast(requireContext(),it.message)
            is UserState.Failed -> {
//                isloding(false)
                toast(requireContext(), it.message)
            }

            is UserState.SuccessRegister -> {

                activity?.startActivity(Intent(requireContext(), AuthActivity::class.java)).also {
                    activity?.finish()
                }
            }
//            is UserState.IsLoding -> isloding(it.state)
        }
    }

    private fun doRegister(){
        binding.btnRegiste.setOnClickListener {
            val badge = binding.edBadge.text.toString().trim()
            val fullname = binding.edFullname.text.toString().trim()
            val username = binding.edUsername.text.toString().trim()
            val email = binding.edEmail.text.toString().trim()
            val devisi = binding.edDevisi.text.toString().trim()
            val pangkat = binding.edPangkat.text.toString().trim()
            val alamat = binding.edAlamat.text.toString().trim()
            val stts = binding.edStts.text.toString().trim()
            val phone = binding.edPhone.text.toString().trim()
            val passw = binding.edPass.text.toString().trim()

            if (!it.ValidationBadge(badge).stts) {
                binding.edBadge.error = it.ValidationBadge(badge).msg
                binding.edBadge.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationFullname(fullname).stts) {
                binding.edFullname.error = it.ValidationFullname(fullname).msg
                binding.edFullname.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationUsername(username).stts) {
                binding.edUsername.error = it.ValidationUsername(username).msg
                binding.edUsername.requestFocus()
                return@setOnClickListener
            }

            if (!it.ValidationEmail(email).stts) {
                binding.edEmail.error = it.ValidationEmail(email).msg
                binding.edEmail.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationDevisi(devisi).stts) {
                binding.edDevisi.error = it.ValidationDevisi(devisi).msg
                binding.edDevisi.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationPangkat(pangkat).stts) {
                binding.edPangkat.error = it.ValidationPangkat(pangkat).msg
                binding.edPangkat.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationAlamat(alamat).stts) {
                binding.edAlamat.error = it.ValidationAlamat(alamat).msg
                binding.edAlamat.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationStts(stts).stts) {
                binding.edStts.error = it.ValidationStts(stts).msg
                binding.edStts.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationPhone(phone).stts) {
                binding.edPhone.error = it.ValidationPhone(phone).msg
                binding.edPhone.requestFocus()
                return@setOnClickListener
            }


            if (!it.ValidationPassword(passw).stts) {
                binding.edPass.error = view?.ValidationPassword(passw)?.msg
                binding.edPass.requestFocus()
                return@setOnClickListener
            }

                userViewModel.register(badge,fullname,username,email,devisi,pangkat,alamat,stts, phone,passw)
        }
    }
}