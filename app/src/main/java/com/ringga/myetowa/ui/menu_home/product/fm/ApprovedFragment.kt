package com.ringga.myetowa.ui.menu_home.product.fm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ringga.myetowa.data.adapter.ListOrderUserAdapter
import com.ringga.myetowa.databinding.FragmentApprovedBinding
import com.ringga.myetowa.ui.menu_home.UserHomeState
import com.ringga.myetowa.ui.menu_home.UserHomeViewModel
import com.ringga.security.util.toast


class ApprovedFragment : Fragment() {
    companion object {
        fun newInstance() = ApprovedFragment()
    }
    private lateinit var userViewModel: UserHomeViewModel
    private var _binding: FragmentApprovedBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        userViewModel = ViewModelProviders.of(this).get(UserHomeViewModel::class.java)
        _binding = FragmentApprovedBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        userViewModel.getOrderUser(requireContext(),"approved")
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

            }
            is UserHomeState.userOrder ->{
                binding.rvApproved.adapter?.let { adapter ->
                    if (adapter is ListOrderUserAdapter) {
                        adapter.setLagu(it.data.data)
                    }
                }
            }
//            is UserState.IsLoding -> isloding(it.state)
        }
    }

    private fun setupRecler() {
        binding.rvApproved.apply {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = ListOrderUserAdapter(mutableListOf(), requireContext(), requireFragmentManager())

        }
    }
}