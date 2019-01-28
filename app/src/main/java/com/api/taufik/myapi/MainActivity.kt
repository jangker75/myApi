package com.api.taufik.myapi

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import com.api.taufik.myapi.R.id.*

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        //convert Gson
        val retrofit = Retrofit.Builder()
            .baseUrl("http://liveapps.ddns.net/")
            .client(OkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
    //        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)

        //showdata
        api.getPosts().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                d("TAUFIK", "onFailure")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body()!!)
                //  d("TAUFIK","onResponse: ${response.body()!![0]}")
            }

        })
    }

    //function show data
    private fun showData(users: List<User>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(users)
        }
    }
}

