package com.example.android.popularmoviesstage1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_TITLE;
import static com.example.android.popularmoviesstage1.Data.Contract.OVERVIEW;
import static com.example.android.popularmoviesstage1.Data.Contract.POSTER_PATH;
import static com.example.android.popularmoviesstage1.Data.Contract.RELEASE_DATE;
import static com.example.android.popularmoviesstage1.Data.Contract.TITLE;
import static com.example.android.popularmoviesstage1.Data.Contract.VOTE_AVERAGE;

public class DetailMoviesActivity extends AppCompatActivity {
    //field to store the movie details
    public TextView mTitle , mReleaseDate , mVoteAverage , mPlotSynposis;
    public ImageView mMoviePoster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        //Reference
        mTitle = findViewById(R.id.original_title_tv);
        mReleaseDate = findViewById(R.id.release_date);
        mVoteAverage = findViewById(R.id.vote_average);
        mPlotSynposis = findViewById(R.id.plot_synposis);
        mMoviePoster = findViewById(R.id.movie_poster);

        Intent intentStartDetailActivity = getIntent();

           //get the intent

        if (intentStartDetailActivity.hasExtra(Intent.EXTRA_TEXT)){
            getIntent().getParcelableExtra(Intent.EXTRA_TEXT);
            mTitle.setText(TITLE);}

        if (intentStartDetailActivity.hasExtra(Intent.EXTRA_TEXT)){
            getIntent().getParcelableExtra(Intent.EXTRA_TEXT);
            mPlotSynposis.setText(OVERVIEW);}

    }
}
