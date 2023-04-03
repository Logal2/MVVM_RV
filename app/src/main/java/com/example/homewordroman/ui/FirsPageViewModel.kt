package com.example.homewordroman.ui

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.homewordroman.data.AlbumId
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homewordroman.State.State
import com.example.homewordroman.data.ResultApi
import com.example.homewordroman.retrofit.ApiService
import com.example.homewordroman.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.io.IOException
import javax.security.auth.callback.Callback

class FirsPageViewModel : ViewModel() {

    private val liveData: MutableLiveData<State> = MutableLiveData(  )

//    private val _uiState = MutableStateFlow(State.NoData())
//    val uiState = _uiState.asStateFlow()


    init {
        liveData.postValue(State.NoData())
    }

    suspend fun makeApiCall() {

//            val retrofitInstance = RetrofitInstance.getRetrofitInstance()
//            val retroService = retrofitInstance.create(RetrofitServiceInterface::class.java)
//            val call = retroService.getAlbumResponse()
//            val albumResponse = call.

        viewModelScope.launch {
            val apiManager = RetrofitInstance.getRetrofitInstance().create(ApiService::class.java)

            try {
                val data = apiManager.getAlbumResponse()
                if (data.isSuccessful && data.body() != null) {
                    liveData.postValue(State.Success(data.body()))
                }
            } catch (e: IOException) {
                liveData.postValue(State.Error("Error: not found", null))
                Log.d("MyTag", e.message.toString())
            }


        }


    }



}

