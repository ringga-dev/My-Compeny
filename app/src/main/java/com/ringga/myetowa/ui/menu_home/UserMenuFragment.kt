package com.ringga.myetowa.ui.menu_home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.databinding.FragmentUserMenuBinding
import android.content.Intent
import com.ringga.myetowa.ui.menu_home.user.UserActivity


class UserMenuFragment : Fragment() {

    companion object {
        fun newInstance()=  UserMenuFragment()
    }

    private var _binding: FragmentUserMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

}