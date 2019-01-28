package com.api.taufik.myapi

import com.squareup.moshi.Json

data class Data(
    @Json(name = "Nama")
    val nama: String,
    @Json(name = "No_STNK")
    val noSTNK: String,
    @Json(name = "id")
    val id: Int
)