package com.ringga.myetowa.ui.menu_home.user.fm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.load
import com.ringga.myetowa.data.adapter.ListOrderUserAdapter
import com.ringga.myetowa.databinding.FragmentMyProfileBinding
import com.ringga.myetowa.ui.menu_home.UserHomeState
import com.ringga.myetowa.ui.menu_home.UserHomeViewModel
import com.ringga.security.util.toast


class MyProfileFragment : Fragment() {
    companion object {
        fun newInstance() = MyProfileFragment()
    }
    private lateinit var userViewModel: UserHomeViewModel
    private var _binding: FragmentMyProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userViewModel = ViewModelProviders.of(this).get(UserHomeViewModel::class.java)
        _binding = FragmentMyProfileBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userViewModel.getUser(requireContext())
        userViewModel.getOrderUser(requireContext(),"all")
        setupRecler()

//        binding.tvName
        userViewModel.getState().observer(this, Observer {
            handleUiState(it)
        })
    }

    private fun handleUiState(it: UserHomeState) {
        when (it) {
            is UserHomeState.Error -> {
//                isloding(false)
                toast(requireContext(), it.err)
            }
            is UserHomeState.ShoewToals -> toast(requireContext(), it.message)
            is UserHomeState.Failed -> {
//                isloding(false)
                toast(requireContext(), it.message)
            }

            is UserHomeState.userData -> {
                binding.imageProfile.load("https://picsum.photos/200/300"){
                    allowHardware(false)
                }
                binding.tvName.text = it.data.fullname
                binding.tvBadge.text= it.data.badge

            }
            is UserHomeState.userOrder ->{

                binding.rvListOrder.adapter?.let { adapter ->
                    if (adapter is ListOrderUserAdapter) {
                        adapter.setLagu(it.data.data)
                    }
                }
            }
//            is UserState.IsLoding -> isloding(it.state)
        }
    }

    private fun setupRecler() {
        binding.rvListOrder.apply {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = ListOrderUserAdapter(mutableListOf(), requireContext(), requireFragmentManager())

        }
    }
}