package com.api.taufik.myapi
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list_artikel")
    fun getPosts(): Call<List<User>>
}