package com.ringga.myetowa.ui.home.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import coil.load
import com.ringga.myetowa.R
import com.ringga.myetowa.data.database.PreferencesToken.Companion.getToken
import com.ringga.myetowa.databinding.FragmentHomeMenuBinding
import com.ringga.myetowa.ui.menu_home.AboutEtowaFragment
import com.ringga.myetowa.ui.menu_home.ProductMenuFragment
import com.ringga.myetowa.ui.menu_home.UserMenuFragment
import com.ringga.myetowa.ui.menu_home.UserHomeState
import com.ringga.myetowa.ui.menu_home.UserHomeViewModel
import com.ringga.security.util.toast


class HomeMenuFragment : Fragment() {

    companion object {
        fun newInstance() = HomeMenuFragment()
    }


    private var _binding: FragmentHomeMenuBinding? = null
    private val binding get() = _binding!!

    private lateinit var userViewModel: UserHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userViewModel = ViewModelProviders.of(this).get(UserHomeViewModel::class.java)
        _binding = FragmentHomeMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userViewModel.getUser(requireContext())

        binding.upbarStts.buttonBack.visibility = View.GONE

        openMainFragment()
        binding.navigasiController.setOnItemSelectedListener {
            when (it) {


                R.id.user_menu -> {
                    openMainFragment()
                }
                R.id.product_menu -> {
                    val transaction = childFragmentManager.beginTransaction()
                    transaction.replace(R.id.menu_container, ProductMenuFragment.newInstance())
                    transaction.commit()
                }

                R.id.about -> {
                    val transaction = childFragmentManager.beginTransaction()
                    transaction.replace(R.id.menu_container, AboutEtowaFragment.newInstance())
                    transaction.commit()
                }

            }
        }

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
                binding.upbarProfile.ivProfile.load("https://picsum.photos/200/300"){
                    allowHardware(false)
                }
                "Hello, ${it.data.fullname}".also { binding.upbarProfile.tvName.text = it }
                Log.i("DATA", it.data.fullname )

            }
//            is UserState.IsLoding -> isloding(it.state)
        }
    }


    private fun openMainFragment() {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.menu_container, UserMenuFragment.newInstance())
        transaction.commit()
    }
}