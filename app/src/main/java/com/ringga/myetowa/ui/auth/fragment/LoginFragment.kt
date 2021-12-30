package com.ringga.myetowa.ui.auth.fragment

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.databinding.FragmentLoginBinding
import com.ringga.myetowa.ui.home.HomeActivity
import com.ringga.security.util.cek_email
import com.ringga.security.util.snackbar


class LoginFragment : Fragment() {
    companion object {
        fun newInstance() = LoginFragment()
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.loginButton.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))

//            binding.loading.visibility = View.VISIBLE
//            val email = binding.edMail.text.toString().trim()
//            val password = binding.edPass.text.toString().trim()
//
//            if (email.isEmpty()) {
//                binding.edMail.error = "Email required"
//                binding.edMail.requestFocus()
//                binding.loading.visibility = View.GONE
//                return@setOnClickListener
//            }
//            if (!cek_email(email)) {
//                binding.edMail.error = "ini bukan format email"
//                binding.edMail.requestFocus()
//                binding.loading.visibility = View.GONE
//                return@setOnClickListener
//            }
//
//            if (password.isEmpty()) {
//                binding.edPass.error = "Password required"
//                binding.edPass.requestFocus()
//                binding.loading.visibility = View.GONE
//                return@setOnClickListener
//            }
//            login(email, password, it)
        }








        binding.btnCekConetion.setOnClickListener { view ->
            snackbar(view)
        }
    }

    private fun login(email: String, password: String, it: View?) {
        //proses login
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