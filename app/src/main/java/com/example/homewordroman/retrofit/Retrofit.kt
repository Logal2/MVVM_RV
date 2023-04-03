package com.example.homewordroman.retrofit

import com.example.homewordroman.data.ResultApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RetrofitInstance {

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
// [ я получаю массив
// Массив [ я должен создать новый класс, с массивом ответа
// { я получаю список
// когда получаю список { я должен записать его в новый класс
