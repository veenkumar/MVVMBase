package com.veen.baseproject.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.veen.baseproject.base.BaseViewModel
import com.veen.baseproject.model.CommonResponse
import com.veen.baseproject.model.login.LoginReq
import com.veen.baseproject.service.api.NetworkResult
import com.veen.baseproject.service.api.Repository
import com.veen.baseproject.utils.CommonUtils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: Repository,
    application: Application
) : BaseViewModel(application) {
    private val _response: MutableLiveData<NetworkResult<CommonResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<CommonResponse>> = _response

    fun fetchLoginResponse() = viewModelScope.launch {
        repository.getLogin(
            LoginReq(
                "2022-05-03",
                "1qwsderftyuiop",
                "praveen kumar",
                "9015494218",
                "2022-05-03T16:56:50.972Z"
            )
        ).collect { values ->
            _response.value = values
            Log.d(TAG, "fetchDogResponse: $values")
        }
    }
}