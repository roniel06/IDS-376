package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import retrofit2.http.GET


interface MarsApiService {
    // list of mars photos
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
