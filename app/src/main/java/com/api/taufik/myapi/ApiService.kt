package com.api.taufik.myapi
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST("db")
    fun getPosts( ): Call<List<User>>
}
//      @GET("/")
 //   fun getPosts(): Call<List<User>>