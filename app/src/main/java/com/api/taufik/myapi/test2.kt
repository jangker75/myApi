package com.api.taufik.myapi

import com.squareup.moshi.Json

data class test2(
    @Json(name = "api_authorization")
    val apiAuthorization: String,
    @Json(name = "api_http")
    val apiHttp: Int,
    @Json(name = "api_message")
    val apiMessage: String,
    @Json(name = "api_status")
    val apiStatus: Int,
    @Json(name = "data")
    val `data`: List<Data>
)