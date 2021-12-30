package com.ringga.myetowa.ui.menu_home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.databinding.FragmentAboutEtowaBinding
import com.ringga.myetowa.ui.menu_home.about.AboutActivity
import com.ringga.myetowa.ui.menu_home.user.UserActivity


class AboutEtowaFragment : Fragment() {
    companion object {
        fun newInstance()=  AboutEtowaFragment()
    }

    private var _binding: FragmentAboutEtowaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutEtowaBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)



        binding.menuAboutEtowa.setOnClickListener {
            val chage = Intent(requireContext(), AboutActivity::class.java)
            chage.putExtra("fragment", "about")
            startActivity(chage)
        }

        binding.menuFisiMisi.setOnClickListener {
            val chage = Intent(requireContext(), AboutActivity::class.java)
            chage.putExtra("fragment", "fisimisi")
            startActivity(chage)
        }

        binding.menuImageEtowa.setOnClickListener {
            val chage = Intent(requireContext(), AboutActivity::class.java)
            chage.putExtra("fragment", "imageetowa")
            startActivity(chage)
        }
        binding.menuRatingEtowa.setOnClickListener {
            val chage = Intent(requireContext(), AboutActivity::class.java)
            chage.putExtra("fragment", "ratingetowa")
            startActivity(chage)
        }
    }
}