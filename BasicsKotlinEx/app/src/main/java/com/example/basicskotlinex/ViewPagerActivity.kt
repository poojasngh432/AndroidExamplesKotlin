package com.example.basicskotlinex

import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.basicskotlinex.viewpager.adapter.PetAdapter
import com.example.basicskotlinex.viewpager.data.model.PetsModel


class ViewPagerActivity : AppCompatActivity() {
    private lateinit var adapter: PetAdapter
    private lateinit var models: ArrayList<PetsModel>
    private lateinit var viewPager: ViewPager
    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        viewPager = findViewById(R.id.view_pager)
        sliderDotspanel = findViewById(R.id.slider_dots)

        models = ArrayList()
        models.add(PetsModel(R.drawable.blue_mug,"Dobby", "Dog"))
        models.add(PetsModel(R.drawable.black_hat,"Kitto", "Cat"))
        models.add(PetsModel(R.drawable.black_shirt_female,"Cozmo", "Lambardor"))
        models.add(PetsModel(R.drawable.black_shirt_male,"Tiger", "German Shepherd"))
        models.add(PetsModel(R.drawable.france_mtn,"Husky", "Husky"))
        models.add(PetsModel(R.drawable.foggy_iceland,"Cat", "Unknown"))
        adapter = PetAdapter(models, this@ViewPagerActivity)
        viewPager.adapter = adapter

        // Disable clip to padding
        viewPager.setClipToPadding(false)
        // set padding manually, the more you set the padding the more you see of prev & next page
        viewPager.setPadding(40, 0, 40, 0)

        val margin = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            20 * 2.toFloat(),
            resources.displayMetrics
        ).toInt()
        viewPager.setPageMargin(-margin)

        dotscount = adapter.count

        val dots = arrayOfNulls<ImageView>(dotscount)

        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(this,
                    R.drawable.non_active_dot))
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                this, R.drawable.active_dot)
        )

        viewPager.setOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int){}

            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@ViewPagerActivity,R.drawable.non_active_dot)
                    )
                }
                dots[position]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@ViewPagerActivity,R.drawable.active_dot)
                )
            }
        })
    }
}