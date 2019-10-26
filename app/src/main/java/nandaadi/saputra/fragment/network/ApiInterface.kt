package nandaadi.saputra.fragment.network

import nandaadi.saputra.fragment.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movie/popular")
    fun getPopularMovie(@Query("api_key") apiKey: String) : Call<MovieResponse>
}