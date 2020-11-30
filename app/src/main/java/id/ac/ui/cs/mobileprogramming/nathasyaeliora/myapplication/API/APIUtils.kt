package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.API

import id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.API.RetrofitClient.getClient

object ApiUtils {
    const val BASE_URL = "https://7a9e624925f8fc7a926faaf7424d8a57.m.pipedream.net"
    val aPIService: APIService
        get() = getClient(BASE_URL)!!.create(APIService::class.java)
}