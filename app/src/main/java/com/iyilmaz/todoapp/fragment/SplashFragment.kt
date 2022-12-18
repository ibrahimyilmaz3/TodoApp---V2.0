package com.iyilmaz.todoapp.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.iyilmaz.todoapp.R
import com.iyilmaz.todoapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //BINDING
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root

        //SPLASH FOR 3 SECONDS
        Handler(Looper.getMainLooper()).postDelayed({
            if (onboardFinished()) {
                findNavController().navigate(R.id.action_splashFragment_to_tasksFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }, 3000)
        return view
    }

    //SHOW ONBOARD ONLY ONCE
    private fun onboardFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onboard", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

}