package com.api.taufik.myapi


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.d
import com.api.taufik.myapi.masterAPI.getRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private val data: MutableList<Data> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = getRetrofit.create(ApiService::class.java)

        retrofit.getData("111", "123456")
            .enqueue(object :retrofit2.Callback<LoginModel>{
                override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                  tvNotif.text="gagal"
                }

                override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                 val data = response?.body()
                    tvNotif.text=data?.apiMessage
                    tv1.text=data?.kodeAnggota
                    tv2.text=data?.nama
                    tv3.text=data?.noPlat
                }

            })


    }

}