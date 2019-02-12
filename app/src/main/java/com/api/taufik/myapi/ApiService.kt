package com.api.taufik.myapi
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("login?")
    fun getData(@Query("kode_anggota") kode_anggota: String, @Query("password") password: String): Call<LoginModel>
}
//      @GET("/")
//   fun getPosts(): Call<List<User>>