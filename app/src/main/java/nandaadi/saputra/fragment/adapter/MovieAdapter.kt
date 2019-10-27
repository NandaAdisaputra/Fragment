package nandaadi.saputra.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_list.view.*
import nandaadi.saputra.fragment.R
import nandaadi.saputra.fragment.model.Movie
import nandaadi.saputra.fragment.model.ResultsItem

class MovieAdapter(val movies : ArrayList<ResultsItem>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies.get(position))
    }

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(view)
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private var movie : ResultsItem? = null
        override fun onClick(p0: View?) {
            Toast.makeText(view.context, "ResultsItem Telah di Klik", Toast.LENGTH_LONG).show()
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: ResultsItem) {
            this.movie = movie
            val imageUrl = StringBuilder()
            imageUrl.append(view.context.getString(R.string.BASE_URL_IMAGE)).append(movie.posterPath)
            view.tv_title.setText(movie.originalTitle)
            Glide.with(view.context).load(imageUrl.toString()).into(view.iv_poster)
        }
    }
}