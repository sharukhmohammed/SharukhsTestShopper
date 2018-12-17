package test.sharukh.sharukhshopper.model.network

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import test.sharukh.sharukhshopper.model.data.MyMart

interface API {

    @GET("api.json ")
    fun getData(): Call<MyMart>

    companion object {
        operator fun invoke(): API {

            return Retrofit.Builder()
                .client(OkHttpClient())
                .baseUrl(" https://s3.ap-south-1.amazonaws.com/org.whatsmad.test/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
        }
    }


}