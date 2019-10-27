package nandaadi.saputra.fragment.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movie.*
import kotlinx.android.synthetic.main.app_bar_main.*
import nandaadi.saputra.fragment.BuildConfig
import nandaadi.saputra.fragment.R
import nandaadi.saputra.fragment.adapter.MovieAdapter
import nandaadi.saputra.fragment.model.Movie
import nandaadi.saputra.fragment.model.MovieResponse
import nandaadi.saputra.fragment.model.ResultsItem
import nandaadi.saputra.fragment.network.ApiClient
import nandaadi.saputra.fragment.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
class MovieActivity : AppCompatActivity() {
    private val TAG : String = MovieActivity::class.java.canonicalName.toString()
    private lateinit var movies : ArrayList<ResultsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        setSupportActionBar(toolbar)

        rv_movies.layoutManager = GridLayoutManager(applicationContext, 2) as RecyclerView.LayoutManager?

        val apiKey = BuildConfig.API_KEY
        val apiInterface : ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)
        getPopularMovies(apiInterface, apiKey)
    }

    fun getPopularMovies(apiInterface: ApiInterface, apiKey : String) {
        val call : Call<MovieResponse> = apiInterface.getPopularMovie(apiKey)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.d("$TAG", "Gagal Fetch Popular Movie")
            }

            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
                movies = response!!.body()!!.results as ArrayList<ResultsItem>
                Log.d("$TAG", "Movie size ${movies.size}")
                rv_movies.adapter = MovieAdapter(movies)
            }

        })
    }

}

