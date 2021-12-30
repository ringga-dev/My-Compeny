package com.ringga.karyawan.ui.lingkungan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CursorAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ringga.karyawan.data.adapter.CuacaAdapter
import com.ringga.karyawan.databinding.ActivityCuacaBinding
import com.ringga.karyawan.pekerjaan.toals
import com.ringga.karyawan.ui.viewModel.CuacaViewModel
import com.ringga.karyawan.ui.viewModel.UserState

class CuacaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCuacaBinding
    private lateinit var viewModel: CuacaViewModel
    var kebupatenAdapter: ArrayAdapter<String>? = null
    var kabupatenList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCuacaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(CuacaViewModel::class.java)

        viewModel.getState().observer(this, Observer {
            handleUiState(it)
        })
        setupRecler()
        viewModel.getWilayah("cuaca", "list")

        binding.spinerWilayah.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
            viewModel.getCuaca("cuaca", kabupatenList[pos])
        }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
})
    }

    private fun handleUiState(it: UserState) {
        when (it) {

            is UserState.Error -> {
//                isloding(false)
                toals(this, it.err)

            }
            is UserState.ShoewToals -> toals(this, it.message)
            is UserState.Failed -> {
//                isloding(false)
                toals(this, it.message)
            }

            is UserState.Success -> {

                val data =it.data
                for (i in 0 until data.size) {
                    kabupatenList.add(data[i])
                    kebupatenAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, kabupatenList)
                    kebupatenAdapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.spinerWilayah.setAdapter(kebupatenAdapter)
                }

           }
            is UserState.Cuaca ->{
                binding.rvCuaca.adapter?.let { adapter ->
                    if (adapter is CuacaAdapter) {
                        adapter.setWallpapers(it.data)
                    }
                }
            }
//            is UserState.IsLoding -> isloding(it.state)
        }
    }

    private fun setupRecler() {
        binding.rvCuaca.apply {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            adapter = CuacaAdapter(mutableListOf(), this@CuacaActivity)

        }
    }

}


