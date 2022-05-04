package com.veen.baseproject.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.veen.baseproject.base.BaseFragment
import com.veen.baseproject.databinding.FragmentMainBinding

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

}