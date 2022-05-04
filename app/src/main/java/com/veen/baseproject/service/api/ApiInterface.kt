package com.veen.baseproject.service.api

import com.veen.baseproject.model.CommonResponse
import com.veen.baseproject.model.login.LoginReq
import com.veen.baseproject.utils.CommonUtils.login
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
/*    @POST(Login_api)
    suspend fun login(@Body loginReq: LoginReq): Response<LoginRes>*/

/*    @POST(Meeting_api)
    suspend fun meeting(
        @Header("Authorization") token: String,
        @Body meetingReq: MeetingReq
    ): Response<MeetingRes>*/

    @POST(login)
    suspend fun getLogin(@Body loginReq: LoginReq): Response<CommonResponse>
}