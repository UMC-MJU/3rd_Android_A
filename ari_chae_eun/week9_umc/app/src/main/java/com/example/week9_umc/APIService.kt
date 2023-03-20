package com.example.week9_umc

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    // 맨 앞에 있는 백슬레시를 없애야 한다.
    @GET("app/users/email-check")
    fun getCheckEmail (
       @Query("email") email : String
    ): Call<Response>
}