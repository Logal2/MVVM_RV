package com.example.homewordroman.retrofit

import com.example.homewordroman.data.ResultApi
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/albums/1/photos")
    suspend fun getAlbumResponse(): Response<ResultApi>
}