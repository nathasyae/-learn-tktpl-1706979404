package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Post {
    @SerializedName("wifi_list")
    @Expose
    var wifi_list: ArrayList<String>? = null

    override fun toString(): String {
        return "Post{" +
                "wifi_list=" + wifi_list.toString() +
                '}'
    }
}