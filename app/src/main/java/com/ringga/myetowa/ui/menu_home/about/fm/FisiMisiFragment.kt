package com.ringga.myetowa.ui.menu_home.about.fm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.databinding.FragmentFisiMisiBinding


class FisiMisiFragment : Fragment() {


    companion object {
        fun newInstance() = FisiMisiFragment()
    }

    private var _binding: FragmentFisiMisiBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFisiMisiBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

}