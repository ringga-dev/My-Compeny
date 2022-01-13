package com.ringga.myetowa.ui.menu_home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.databinding.FragmentUserMenuBinding
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.ringga.myetowa.data.database.PreferencesToken
import com.ringga.myetowa.data.database.SharedPrefManager
import com.ringga.myetowa.ui.auth.UserState
import com.ringga.myetowa.ui.home.HomeActivity
import com.ringga.myetowa.ui.menu_home.user.UserActivity
import com.ringga.security.util.toast


class UserMenuFragment : Fragment() {

    companion object {
        fun newInstance()=  UserMenuFragment()
    }
    private lateinit var userViewModel: UserHomeViewModel
    private var _binding: FragmentUserMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userViewModel = ViewModelProviders.of(this).get(UserHomeViewModel::class.java)
        _binding = FragmentUserMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.menuMyProfile.setOnClickListener {
            val chage = Intent(requireContext(), UserActivity::class.java)
            chage.putExtra("fragment", "myprofile")
            startActivity(chage)
        }

        binding.menuChagePassword.setOnClickListener {
            val chage = Intent(requireContext(), UserActivity::class.java)
            chage.putExtra("fragment", "chagepassword")
            startActivity(chage)
        }

        binding.menuEditProfile.setOnClickListener {
            val chage = Intent(requireContext(), UserActivity::class.java)
            chage.putExtra("fragment", "editprofile")
            startActivity(chage)
        }
        binding.menuChageImage.setOnClickListener {
            val chage = Intent(requireContext(), UserActivity::class.java)
            chage.putExtra("fragment", "chageimage")
            startActivity(chage)
        }

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


}