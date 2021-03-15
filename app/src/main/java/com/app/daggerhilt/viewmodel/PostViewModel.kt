package com.app.daggerhilt.viewmodel

import androidx.lifecycle.*
import com.app.daggerhilt.model.Post
import com.app.daggerhilt.repository.PostRepository
import com.app.daggerhilt.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    fun getPost() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = postRepository.getPost()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}