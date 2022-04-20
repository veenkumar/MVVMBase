package com.veen.baseproject.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.veen.baseproject.R
import com.veen.baseproject.base.BaseFragment
import com.veen.baseproject.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>(){
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

    override fun onViewBindingCreated(savedInstanceState: Bundle?) {
        super.onViewBindingCreated(savedInstanceState)
        //todo rest of code here
    }
}