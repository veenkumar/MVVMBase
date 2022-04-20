package com.veen.baseproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding> : DialogFragment() {
    protected val viewModel by viewModels<BaseViewModel>()
    lateinit var binding: B
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater, container, false)
        onViewBindingCreated(savedInstanceState)
        return binding.root
    }
    open fun onViewBindingCreated(savedInstanceState: Bundle?) {}
}