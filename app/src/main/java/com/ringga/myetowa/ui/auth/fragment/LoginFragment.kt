package com.ringga.myetowa.ui.auth.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ringga.myetowa.data.database.PreferencesToken
import com.ringga.myetowa.data.database.SharedPrefManager
import com.ringga.myetowa.data.utils.ValidationEmail
import com.ringga.myetowa.data.utils.ValidationPassword
import com.ringga.myetowa.data.utils.ValidationUsername
import com.ringga.myetowa.data.utils.ValidationUsernameEmail
import com.ringga.myetowa.databinding.FragmentLoginBinding
import com.ringga.myetowa.ui.auth.AuthViewModel
import com.ringga.myetowa.ui.auth.UserState
import com.ringga.myetowa.ui.home.HomeActivity
import com.ringga.security.util.snackbar
import com.ringga.security.util.toast


class LoginFragment : Fragment() {
    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var userViewModel: AuthViewModel
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userViewModel.getState().observer(this, Observer {
            handleUiState(it)
        })


        binding.btnCekConetion.setOnClickListener { view ->
            snackbar(view)
        }

        doLogin()
    }

    private fun handleUiState(it: UserState) {
        when (it) {

            is UserState.Error -> {
//                isloding(false)
                toast(requireContext(), it.err)
            }
            is UserState.ShoewToals -> toast(requireContext(), it.message)
            is UserState.Failed -> {
//                isloding(false)
                toast(requireContext(), it.message)
            }

            is UserState.SuccessLogin -> {
                SharedPrefManager.getInstance(requireContext()).saveUser(it.data.data)
                PreferencesToken.setToken(requireContext(), it.data.token)
                Toast.makeText(requireContext(), it.data.toString(), Toast.LENGTH_SHORT).show()

                startActivity(Intent(requireContext(), HomeActivity::class.java))
                activity?.finish()
            }
//            is UserState.IsLoding -> isloding(it.state)
        }
    }

    private fun doLogin() {
        binding.loginButton.setOnClickListener {
            val email = binding.edMail.text.toString().trim()
            val passw = binding.edPass.text.toString().trim()
            if (!it.ValidationUsernameEmail(email).stts) {
                binding.edMail.error = it.ValidationEmail(email).msg
                binding.edMail.requestFocus()
                return@setOnClickListener
            }
            if (!it.ValidationPassword(passw).stts) {
                binding.edPass.error = view?.ValidationPassword(passw)?.msg
                binding.edPass.requestFocus()
                return@setOnClickListener
            }
            userViewModel.login(email, passw)
        }
    }

    private fun snackbar(view: View) {
        val ConnectionManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = ConnectionManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            snackbar("Network Available", view)
            Handler().postDelayed({
                val cm =
                    requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                // Network Capabilities of Active Network
                val nc = cm.getNetworkCapabilities(cm.activeNetwork)
                // DownSpeed in MBPS
                val downSpeed = (nc?.linkDownstreamBandwidthKbps)!! / 1000
                // UpSpeed  in MBPS
                val upSpeed = (nc.linkUpstreamBandwidthKbps) / 1000
                // Toast to Display DownSpeed and UpSpeed
                snackbar("Up To: $upSpeed Mbps \nDown Speed: $downSpeed Mbps", view)
            }, 2000)
        } else {
            snackbar("Network Not Available", view)
        }
    }



}