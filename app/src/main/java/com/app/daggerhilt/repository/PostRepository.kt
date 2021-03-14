package com.app.daggerhilt.repository

import com.app.daggerhilt.model.Post
import com.app.daggerhilt.network.PostServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class PostRepository @Inject constructor(private val postApiServiceImp: PostServiceImp) {

    fun getPost(): Flow<List<Post>> = flow {
        val response = postApiServiceImp.getPost()
        emit(response)
    }.flowOn(Dispatchers.IO)
}