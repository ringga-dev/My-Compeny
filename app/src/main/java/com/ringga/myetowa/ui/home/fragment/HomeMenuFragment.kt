package com.ringga.myetowa.ui.home.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ringga.myetowa.R
import com.ringga.myetowa.databinding.FragmentHomeMenuBinding
import com.ringga.myetowa.ui.menu_home.AboutEtowaFragment
import com.ringga.myetowa.ui.menu_home.ProductMenuFragment
import com.ringga.myetowa.ui.menu_home.UserMenuFragment
import com.ringga.security.util.toast


class HomeMenuFragment : Fragment() {

    companion object {
        fun newInstance() = HomeMenuFragment()
    }

    private var _binding: FragmentHomeMenuBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
    }


    private fun openMainFragment() {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.menu_container, UserMenuFragment.newInstance())
        transaction.commit()
    }
}