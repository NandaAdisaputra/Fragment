package nandaadi.saputra.fragment.network

import nandaadi.saputra.fragment.BuildConfig
import nandaadi.saputra.fragment.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("discover/movie?api_key=" + BuildConfig.API_KEY + "&language=en-US")
    fun getPopularMovie(@Query("api_key") apiKey: String) : Call<MovieResponse>
}