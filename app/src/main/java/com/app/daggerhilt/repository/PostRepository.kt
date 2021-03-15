package com.app.daggerhilt.repository

import com.app.daggerhilt.network.PostApiService
import javax.inject.Inject

class PostRepository @Inject constructor(private val postApiService: PostApiService) {
    suspend fun getPost() = postApiService.getPost()
}