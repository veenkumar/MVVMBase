package com.veen.baseproject.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.veen.baseproject.base.BaseActivity
import com.veen.baseproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(){
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onViewBindingCreated(savedInstanceState: Bundle?) {
        super.onViewBindingCreated(savedInstanceState)
        //todo rest of code here
    }
}