package com.example.android.popularmoviesstage1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmoviesstage1.Data.Contract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyHolder> {

    ArrayList<MovieData> movieDataArrayList ;
    private LayoutInflater inflater;
    private Context mContext;
    public void addMovieArrayList(ArrayList<MovieData> resultMovieDataArrayList){
        movieDataArrayList=resultMovieDataArrayList;
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
    public void onBindViewHolder(MovieAdapter.MyHolder holder, int position) {
        holder.title.setText(movieDataArrayList.get(position).getOriginal_title());
        //view Images.
        Picasso.with(mContext)
                .load(Contract.IMAGE_URL + Contract.W500 + movieDataArrayList
                        .get(position).getPoster_image())
                 .into(holder.posterImage);

    }
    // return total item count from List
    @Override
    public int getItemCount() {
        return movieDataArrayList.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView posterImage;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.movie_name);
            posterImage= (ImageView) itemView.findViewById(R.id.poster_image);
        }
    }

}
