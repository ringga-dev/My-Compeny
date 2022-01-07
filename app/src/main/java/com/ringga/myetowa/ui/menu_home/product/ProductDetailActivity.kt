package com.ringga.myetowa.ui.menu_home.product

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ringga.myetowa.databinding.ActivityProductDetailBinding
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.ringga.myetowa.data.adapter.ViewPagerImageAdapte


class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    private val image: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in 0..100) {
            image.add(imageLinks())
        }



        binding.viewPagerMain.apply {
            adapter = ViewPagerImageAdapte(this@ProductDetailActivity, mutableListOf())
        }

        binding.viewPagerMain.adapter?.let { adapter ->
            if (adapter is ViewPagerImageAdapte) {
                adapter.setLagu(image)
            }
        }

        binding.viewPagerMain.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        binding.positionImage.text = "1..${image.size}>>"
                    }
                    image.size - 1 -> {
                        binding.positionImage.text = "<<1..${image.size}"
                    }
                    else -> {
                        binding.positionImage.text = "<<1..${position + 1}..${image.size}>>"
                    }
                }

            }
        })
    }

    private fun imageLinks(): String {
        // array of links to free images on the internet
        val links = arrayListOf(
            "https://images.freeimages.com/images/large-previews/825/linked-hands-1308777.jpg",
            "https://images.unsplash.com/photo-1541443131876-44b03de101c5?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=mathieu-renier-4WBvCqeMaDE-unsplash.jpg",
            "https://images.unsplash.com/photo-1549399542-7e3f8b79c341?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=roberto-nickson-zu95jkyrGtw-unsplash.jpg",
            "https://www.cnet.com/a/img/XtH050ErlMIQxKn_HYUx2plJnDc=/940x528/2020/12/17/c9a829c8-69d6-4299-b2d0-cf9624aa7556/2021-acura-tlx-a-spec-65.jpg",
            "https://cdn.jdpower.com/JDPA_2021%20Acura%20TLX%20Advance%20Red%20Front%20View.jpg",
            "https://s3-us-east-2.amazonaws.com/matter-blog/2020/09/People_Person_Cover_Image.png",
            "https://images.fandango.com/ImageRenderer/0/0/redesign/static/img/default_poster.png/0/images/masterrepository/other/ant_man_ver5.jpg",
        )

        return links.random()

    }
}