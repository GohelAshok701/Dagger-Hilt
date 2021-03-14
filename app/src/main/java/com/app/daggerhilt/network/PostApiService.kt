package com.app.daggerhilt.network

import com.app.daggerhilt.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getPost(): List<Post>
}