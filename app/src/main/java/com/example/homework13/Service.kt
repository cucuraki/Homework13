package com.example.homework13

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    private const val BASE_URL = "https://reqres.in/api/products/"
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory
                    .create(moshi)
            )
            .build()
    }
    fun service() = retrofitBuilder.create(Service::class.java)
}

// There is problem for data class, test class works fine
data class Test(val data: Data, val support: Support){
data class Data(val id: Int, val name: String, val year: Int, val color: String, val pantone_value: String)
data class Support(val url: String, val text:String)

}

interface Service {
    @GET("3")
    suspend fun getInfo(): Response<Test>

}