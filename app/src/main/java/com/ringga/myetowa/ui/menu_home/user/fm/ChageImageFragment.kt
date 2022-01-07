package com.ringga.myetowa.ui.menu_home.user.fm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.databinding.FragmentChageImageBinding
import android.content.pm.ActivityInfo

import android.app.Activity
import coil.api.load
import com.ringga.myetowa.R


class ChageImageFragment : Fragment() {
    companion object {
        fun newInstance() = ChageImageFragment()
    }

    private var _binding: FragmentChageImageBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChageImageBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.imageProfile.load(R.drawable.assess_iblis)
    }

    override fun onResume() {
        super.onResume()
        activity?.requestedOrientation  =ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }
}