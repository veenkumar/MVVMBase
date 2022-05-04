package com.veen.baseproject.service.api

import com.veen.baseproject.model.login.LoginReq
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiInterface: ApiInterface) {
    suspend fun getLogin(loginReq: LoginReq) =
        apiInterface.getLogin(loginReq)
}