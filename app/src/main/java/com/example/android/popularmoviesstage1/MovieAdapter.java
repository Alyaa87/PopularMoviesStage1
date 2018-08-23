package com.example.android.popularmoviesstage1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmoviesstage1.Data.Contract;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_OVERVIEW;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_RATE;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_TITLE;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_URL;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_YEAR;
import static com.example.android.popularmoviesstage1.Data.Contract.OVERVIEW;
import static com.example.android.popularmoviesstage1.Data.Contract.RELEASE_DATE;
import static com.example.android.popularmoviesstage1.Data.Contract.TITLE;
import static com.example.android.popularmoviesstage1.Data.Contract.VOTE_AVERAGE;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyHolder> {

    ArrayList<MovieData> movieDataArrayList ;
    private LayoutInflater inflater;
    private Context mContext;
    public void addMovieArrayList(ArrayList<MovieData> resultMovieDataArrayList){
        movieDataArrayList = resultMovieDataArrayList;
    }
    // create constructor to initialize context and data sent from MainActivity
    public MovieAdapter(Context context, ArrayList<MovieData> data) {
        this.mContext = context;
        inflater = LayoutInflater.from(context);
        this.movieDataArrayList = data;
    }
    // Inflate the layout when viewholder created
    @Override
    public MovieAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }
    // Bind data to the holder.
    @Override
    public void onBindViewHolder(MovieAdapter.MyHolder holder, final int position) {
        final MovieData movies = movieDataArrayList.get( position);
     //view the movie title
        holder.original_title.setText(movies.getOriginal_title());
      
        //view Images.
        Picasso.with(mContext)
                .load(Contract.IMAGE_URL + Contract.W500 + movieDataArrayList
                        .get(position).getPoster_image())
                 .into(holder.posterImage);


            //set onclick listener for the movie items.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(mContext, DetailMoviesActivity.class);
                //put Extra (send intent).
                Bundle bundle = new Bundle();

                bundle.putString(EXTRA_TITLE , movies.getOriginal_title());
                bundle.putString(EXTRA_RATE , String.valueOf(movies.getVoteAverage()));
                bundle.putString(EXTRA_YEAR , movies.getReleaseDate());
                bundle.putString(EXTRA_URL , movies.getPoster_image());
                bundle.putString(EXTRA_OVERVIEW , movies.getOverview());

                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
   }
    // return total item count from List
    @Override
    public int getItemCount() {
        return movieDataArrayList.size();
    }

    public void updateMovies(ArrayList<MovieData> movie_list) {
        this.movieDataArrayList = movie_list;
    }

    class MyHolder extends RecyclerView.ViewHolder{
       public TextView original_title;
        public ImageView posterImage;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            original_title= (TextView) itemView.findViewById(R.id.movie_name);
            posterImage= (ImageView) itemView.findViewById(R.id.poster_image);
        }
    }

}
