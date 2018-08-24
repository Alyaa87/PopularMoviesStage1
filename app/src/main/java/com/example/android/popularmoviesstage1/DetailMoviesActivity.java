package com.example.android.popularmoviesstage1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Property;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.popularmoviesstage1.Data.Contract;
import com.squareup.picasso.Picasso;

import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_OVERVIEW;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_RATE;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_TITLE;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_URL;
import static com.example.android.popularmoviesstage1.Data.Contract.EXTRA_YEAR;
import static com.example.android.popularmoviesstage1.Data.Contract.OVERVIEW;
import static com.example.android.popularmoviesstage1.Data.Contract.POSTER_PATH;
import static com.example.android.popularmoviesstage1.Data.Contract.RELEASE_DATE;
import static com.example.android.popularmoviesstage1.Data.Contract.TITLE;
import static com.example.android.popularmoviesstage1.Data.Contract.VOTE_AVERAGE;

public class DetailMoviesActivity extends AppCompatActivity {
    //field to store the movie details

    private String mUrl;
    private String mTitle;

    public TextView mTitleTxt, mReleaseDate, mVoteAverage, mOverview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        //Reference
        mTitleTxt = findViewById(R.id.original_title_tv);
        mReleaseDate = findViewById(R.id.release_date);
        mVoteAverage = findViewById(R.id.vote_average);
        mOverview = findViewById(R.id.overview);
        ImageView mMoviePoster = (ImageView) findViewById(R.id.movie_poster);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        Intent intentStartDetailActivity = getIntent();
        //get the intent
        Bundle bundle = getIntent().getExtras();

        if (bundle.getString(EXTRA_TITLE) != null) {
            mTitle = bundle.getString(EXTRA_TITLE);
            mTitleTxt.setText(mTitle);
        }

        if (bundle.getString(EXTRA_URL) != null) {
                mUrl = bundle.getString(EXTRA_URL);
        }

        if (bundle.getString(EXTRA_YEAR) != null) {
            mReleaseDate.setText(bundle.getString(EXTRA_YEAR));
        }

        if (bundle.getString(EXTRA_RATE) != null) {
            int number = Integer.parseInt(bundle.getString(EXTRA_RATE));
            float d = (float) ((number * 5) / 10);
            ratingBar.setRating(d);
        }

        if (bundle.getString(EXTRA_OVERVIEW) != null) {
            mOverview.setText(bundle.getString(EXTRA_OVERVIEW));
        }

        Picasso.with(this)
                .load(Contract.IMAGE_URL + Contract.W780 + mUrl)
                .into(mMoviePoster);
    }


}
