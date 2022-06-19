package com.example.movieapps.core.data.main.source.remote

import com.example.movieapps.core.ApiResponse
import com.example.movieapps.core.data.main.source.remote.network.MainService
import com.example.movieapps.core.data.main.source.remote.response.ResponseDetailMovie
import com.example.movieapps.core.data.main.source.remote.response.ResponseGenreList
import com.example.movieapps.core.data.main.source.remote.response.ResponseListMovie
import com.example.movieapps.core.data.main.source.remote.response.ResponseReviewMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

class MainRemoteDataSource(private val mainService: MainService) {

    suspend fun getGenreList(apiKey:String): Flow<ApiResponse<ResponseGenreList>>{
        return flow {
            try {
                val response = mainService.getGenreList(apiKey)
                emit(ApiResponse.Success(response))
            }catch (e: HttpException){
                if (e.code() in 400..499){
                    emit(ApiResponse.Error(e.code().toString()))
                }else if (e.code()==500){
                    emit(ApiResponse.Error(e.code().toString()))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMoviePopular(apiKey:String): Flow<ApiResponse<ResponseListMovie>>{
        return flow {
            try {
                val response = mainService.getMoviePopular(apiKey)
                emit(ApiResponse.Success(response))
            }catch (e: HttpException){
                if (e.code() in 400..499){
                    emit(ApiResponse.Error(e.code().toString()))
                }else if (e.code()==500){
                    emit(ApiResponse.Error(e.code().toString()))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieComingSoon(apiKey:String): Flow<ApiResponse<ResponseListMovie>>{
        return flow {
            try {
                val response = mainService.getMovieComingSoon(apiKey)
                emit(ApiResponse.Success(response))
            }catch (e: HttpException){
                if (e.code() in 400..499){
                    emit(ApiResponse.Error(e.code().toString()))
                }else if (e.code()==500){
                    emit(ApiResponse.Error(e.code().toString()))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieTopRated(apiKey:String): Flow<ApiResponse<ResponseListMovie>>{
        return flow {
            try {
                val response = mainService.getMovieTopRated(apiKey)
                emit(ApiResponse.Success(response))
            }catch (e: HttpException){
                if (e.code() in 400..499){
                    emit(ApiResponse.Error(e.code().toString()))
                }else if (e.code()==500){
                    emit(ApiResponse.Error(e.code().toString()))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieDetail(movieId:String,apiKey:String): Flow<ApiResponse<ResponseDetailMovie>>{
        return flow {
            try {
                val response = mainService.getMovieDetail(movieId, apiKey)
                emit(ApiResponse.Success(response))
            }catch (e: HttpException){
                if (e.code() in 400..499){
                    emit(ApiResponse.Error(e.code().toString()))
                }else if (e.code()==500){
                    emit(ApiResponse.Error(e.code().toString()))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieReview(movieId:String,apiKey:String): Flow<ApiResponse<ResponseReviewMovie>>{
        return flow {
            try {
                val response = mainService.getMovieReview(movieId, apiKey)
                emit(ApiResponse.Success(response))
            }catch (e: HttpException){
                if (e.code() in 400..499){
                    emit(ApiResponse.Error(e.code().toString()))
                }else if (e.code()==500){
                    emit(ApiResponse.Error(e.code().toString()))
                }else{
                    emit(ApiResponse.Empty)
                }
            }catch (e:Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}