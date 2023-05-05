package com.example.android4lesson1.base

import com.example.android4lesson1.utils.Resource
import kotlinx.coroutines.flow.flow

open class BaseRepository {
    fun<T> doRequest(request : suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        }catch (exception : Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}