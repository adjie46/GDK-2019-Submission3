package com.adjiekurniawan.sumbission3_dicoding.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.adjiekurniawan.sumbission3_dicoding.R;
import com.adjiekurniawan.sumbission3_dicoding.models.MovieData;
import com.adjiekurniawan.sumbission3_dicoding.network.Constant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieData> movieDatas;
    private Context context;

    private OnMovieItemSelectedListener onMovieItemSelectedListener;

    public MovieAdapter(Context context) {
        this.context = context;
        movieDatas = new ArrayList<>();
    }

    private void add(MovieData item) {
        movieDatas.add(item);
        notifyItemInserted(movieDatas.size() - 1);
        notifyDataSetChanged();
    }

    public void addAll(List<MovieData> movieDatas) {
        for (MovieData movieData : movieDatas) {
            add(movieData);
        }
        notifyDataSetChanged();
    }

    private void remove(MovieData item) {
        int position = movieDatas.indexOf(item);
        if (position > -1) {
            movieDatas.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public MovieData getItem(int position) {
        return movieDatas.get(position);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        final MovieViewHolder movieViewHolder = new MovieViewHolder(view);
        movieViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = movieViewHolder.getAdapterPosition();
                MovieData movie = movieDatas.get(adapterPos);
                if (onMovieItemSelectedListener != null) {
                    onMovieItemSelectedListener.onItemClick(movieViewHolder.itemView, movie,adapterPos);
                }
            }
        });

        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        final MovieData movieData = movieDatas.get(position);
        holder.bind(movieData);
    }

    @Override
    public int getItemCount() {
        return movieDatas.size();
    }

    public void setOnMovieItemSelectedListener(OnMovieItemSelectedListener onMovieItemSelectedListener) {
        this.onMovieItemSelectedListener = onMovieItemSelectedListener;
    }

    public interface OnMovieItemSelectedListener {
        void onItemClick(View v, MovieData movie, int position);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterImage;
        private TextView posterTitle,
                posterReleaseDate,
                posterDescription;
        private RatingBar posterRating;

        private MovieViewHolder(View itemView) {
            super(itemView);

            posterImage = itemView.findViewById(R.id.posterImage);
            posterTitle = itemView.findViewById(R.id.posterTitle);
            posterRating = itemView.findViewById(R.id.rating);
            posterDescription = itemView.findViewById(R.id.posterDescription);
            posterReleaseDate = itemView.findViewById(R.id.posterReleaseDate);
        }

        private void bind(MovieData movieData) {
            Picasso.get()
                    .load(Constant.IMG_URL + movieData.getPosterPath())
                    .error(R.drawable.ic_broken_image_black_24dp)
                    .into(posterImage);
            posterTitle.setText(movieData.getTitle());
            posterRating.setRating((float) (movieData.getVoteAverage() / 2));
            posterDescription.setText(movieData.getOverview());
            posterReleaseDate.setText(String.format("%s %s",
                    context.getString(R.string.txt_detail_release_date), movieData.getReleaseDate()));
        }
    }


}