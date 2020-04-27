package com.example.moviedbapp.single_movie_details

import androidx.lifecycle.LiveData
import com.example.moviedbapp.data.api.TheMovieDBInterface
import com.example.moviedbapp.data.repository.MovieDetailsNetworkDataSource
import com.example.moviedbapp.data.repository.NetworkState
import com.example.moviedbapp.data.vo.MovieDetailsX
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService:TheMovieDBInterface) {
  lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

  fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetailsX> {


    movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
    movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

    return movieDetailsNetworkDataSource.downloadedMovieResponse
  }

  fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
    return movieDetailsNetworkDataSource.networkState
  }
}
