package com.app.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.app.daggerhilt.util.Status
import com.app.daggerhilt.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel.getPost().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let {
                            Log.d("main", "Success" + it[0])
                        }

                    }
                    Status.LOADING -> {
                        Log.d("main", " Progress visible")
                    }
                    else -> {
                        Log.d("main", "fail")
                    }
                }
            }
        })

        /*postViewModel.mutableLiveData.observe(this, Observer {
            Log.d("main", "" + it[0].body)
        })*/

    }
}