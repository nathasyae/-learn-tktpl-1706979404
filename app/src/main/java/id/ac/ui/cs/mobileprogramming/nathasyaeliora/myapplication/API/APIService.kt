package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.API

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface APIService {
    @POST("/posts")
    @FormUrlEncoded
    fun savePost(
        @Field("wifi_list") wifi_list: ArrayList<String>?,
    ): Call<Post?>?
}