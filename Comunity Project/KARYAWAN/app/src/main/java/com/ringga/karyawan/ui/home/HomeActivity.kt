package com.ringga.karyawan.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.ringga.karyawan.R
import com.ringga.karyawan.databinding.ActivityHomeBinding
import com.ringga.karyawan.ui.home.fragment.DashboardFragment
import com.ringga.karyawan.ui.home.fragment.NotificationFragment
import com.ringga.karyawan.ui.home.fragment.ProfileFragment
import androidx.fragment.app.FragmentTransaction
import com.ringga.karyawan.ui.home.fragment.PopulerFragment


class HomeActivity : AppCompatActivity() {
    lateinit var chip: ChipNavigationBar
    private lateinit var binding: ActivityHomeBinding
    private var stts: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        chip = binding.menu
        binding.btnHide.setOnClickListener {
            if (stts == true) {
                binding.menu.visibility = View.GONE
                binding.btnHide.setImageResource(R.drawable.ic_show)
                stts = false
            } else {
                binding.menu.visibility = View.VISIBLE
                binding.btnHide.setImageResource(R.drawable.ic_hide)
                stts = true
            }
        }

        chip.setItemSelected(
            R.id.nav_dashboard,
            true
        )

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragmentHome,
                DashboardFragment.newInstance()
            ).commit()

//       binding.expandButton.setOnClickListener {
//            if (binding.menu.isExpanded()) {
//                TransitionManager.beginDelayedTransition(binding.fragmentHome, ChangeBounds())
//                binding.menu.collapse()
//            } else {
//                TransitionManager.beginDelayedTransition(binding.fragmentHome, ChangeBounds())
//                binding.menu.expand()
//            }
//        }
        bottomMenu()



    }


    private fun bottomMenu() {
        chip.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(i: Int) {
                when (i) {
                    R.id.nav_profile -> {

                        handleClickLoadRedFragment(ProfileFragment.newInstance())
                    }
                    R.id.nav_dashboard -> {
                        handleClickLoadRedFragment(DashboardFragment.newInstance())
                    }
                    R.id.nav_notification -> {
//                        supportFragmentManager.beginTransaction()
//                            .replace(
//                                R.id.fragmentHome,
//                                NotificationFragment.newInstance()
//                            ).commit()
                        handleClickLoadRedFragment(NotificationFragment.newInstance())
                    }
                    R.id.nav_popular->{
                        handleClickLoadRedFragment(PopulerFragment.newInstance())
                    }
                }
            }
        })
    }

    fun handleClickLoadRedFragment(view: Fragment) {
        val fragmentTransaction= supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(
           R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out
        )
        fragmentTransaction.replace(
            R.id.fragmentHome,
            view,
            "RED_FRAGMENT"
        )
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}