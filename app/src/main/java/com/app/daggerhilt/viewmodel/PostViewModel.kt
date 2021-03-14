package com.app.daggerhilt.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.app.daggerhilt.model.Post
import com.app.daggerhilt.network.PostServiceImp
import com.app.daggerhilt.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {
    val response: LiveData<List<Post>> = postRepository.getPost()
        .catch { e ->
            Log.d("main", "${e.message}")
        }.asLiveData()
}