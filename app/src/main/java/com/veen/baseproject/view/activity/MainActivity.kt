package com.veen.baseproject.view.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.veen.baseproject.R
import com.veen.baseproject.base.BaseActivity
import com.veen.baseproject.databinding.ActivityMainBinding
import com.veen.baseproject.service.api.NetworkResult
import com.veen.baseproject.utils.CommonUtils.TAG
import com.veen.baseproject.utils.CustomLoader
import com.veen.baseproject.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    val viewModel by viewModels<MainViewModel>()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onViewBindingCreated(savedInstanceState: Bundle?) {
        super.onViewBindingCreated(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //todo rest of code here
        fetchdata()
    }

    private fun fetchdata() {
        viewModel.fetchLoginResponse()
        viewModel.response.observe(this) {
            when (it) {
                is NetworkResult.Success -> {
                    Log.d(TAG, "fetchdata: ${it.data}")
                }
                is NetworkResult.Error -> {
                    Log.d(TAG, "fetchdata: ${it.data}")
                }
                is NetworkResult.Loading -> {
                    CustomLoader.showLoader(this)
                }
            }
        }
    }
}