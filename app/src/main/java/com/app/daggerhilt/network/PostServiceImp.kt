package com.app.daggerhilt.network

import com.app.daggerhilt.model.Post
import javax.inject.Inject

class PostServiceImp @Inject constructor(private val postApiService: PostApiService) {

    suspend fun getPost(): List<Post> = postApiService.getPost()
}