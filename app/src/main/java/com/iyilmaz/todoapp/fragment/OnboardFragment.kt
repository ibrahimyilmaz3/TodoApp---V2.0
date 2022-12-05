package com.iyilmaz.todoapp.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.iyilmaz.todoapp.R
import com.iyilmaz.todoapp.adapter.ViewPagerAdapter
import com.iyilmaz.todoapp.databinding.FragmentOnboardBinding


class OnboardFragment : Fragment() {

    private lateinit var binding: FragmentOnboardBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardBinding.inflate(inflater,container,false)

        val animationDrawable = binding.layout1.background as AnimationDrawable
        addAnimation(animationDrawable)

        viewPagerAdapter = ViewPagerAdapter(requireContext())
        binding.viewPager.adapter = viewPagerAdapter

        binding.dotsIndicator.attachTo(binding.viewPager)

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                //Log.i("Tag", position.toString())

                if (position == 1) {
                    binding.layout1.setBackgroundResource(R.drawable.gradient_animation4567)
                    val animationDrawable = binding.layout1.background as AnimationDrawable
                    addAnimation(animationDrawable)
                } else {
                    binding.layout1.setBackgroundResource(R.drawable.gradient_animation123)
                    val animationDrawable = binding.layout1.background as AnimationDrawable
                    addAnimation(animationDrawable)
                }
                if(position == 3) binding.btnGetStarted.visibility = View.VISIBLE
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

        return binding.root
    }

    private fun addAnimation(animationDrawable: AnimationDrawable) {
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()
    }

}