package com.iyilmaz.todoapp.fragment

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.iyilmaz.todoapp.R
import com.iyilmaz.todoapp.adapter.ViewPagerAdapter
import com.iyilmaz.todoapp.databinding.FragmentViewPagerBinding
import com.iyilmaz.todoapp.onboarding.screens.FirstScreen
import com.iyilmaz.todoapp.onboarding.screens.SecondScreen
import com.iyilmaz.todoapp.onboarding.screens.ThirdScreen


class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        binding.btnGetStarted.setOnClickListener {
            //onboardFinished()
            findNavController().navigate(R.id.action_viewPagerFragment_to_tasksFragment)
        }

        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        val adapter =
            ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        val animationDrawable = binding.layout1.background as AnimationDrawable
        addAnimation(animationDrawable)
        binding.dotsIndicator.attachTo(binding.viewPager)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 1) {
                    binding.layout1.setBackgroundResource(R.drawable.gradient_animation4567)
                    val animationDrawable2 = binding.layout1.background as AnimationDrawable
                    addAnimation(animationDrawable2)
                } else {
                    binding.layout1.setBackgroundResource(R.drawable.gradient_animation123)
                    val animationDrawable1 = binding.layout1.background as AnimationDrawable
                    addAnimation(animationDrawable1)
                }
                if (position == 2) binding.btnGetStarted.visibility = View.VISIBLE
            }
        })

        return binding.root
    }

    private fun onboardFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onboard", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

    private fun addAnimation(animationDrawable: AnimationDrawable) {
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()
    }

}