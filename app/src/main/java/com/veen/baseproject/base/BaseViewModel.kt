package com.veen.baseproject.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel(application: Application) : AndroidViewModel(application){
    val apiResponse = MutableLiveData<Any>()
    val errorResponse = MutableLiveData<String>()
}