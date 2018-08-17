package com.example.android.popularmoviesstage1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.popularmoviesstage1.Utils.NetworkUtils;
import com.example.android.popularmoviesstage1.Utils.OpenUtils;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    public static final String ORIGINAL_TITLE = "original_title";
    public static final String POSTER_IMAGE = "poster_image";

    private ArrayList<MovieData> moviesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesArrayList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recycler_view);
        mMovieAdapter = new MovieAdapter(this, moviesArrayList);

        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mMovieAdapter);

        loadMovieData();

    }

    private void loadMovieData() {
        showData();
        String data = NetworkUtils.getResponseFromHttpUrl();
        new AsynTaskMethod().execute(data);
    }
    private void showData() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    //AsyncTask to fetch movie Data.
    public class AsynTaskMethod extends AsyncTask<String, Void, ArrayList<MovieData>> {
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }
        @Override
        protected ArrayList<MovieData> doInBackground(String... params) {
            URL moviesRequestUrl = NetworkUtils.buildUrl();
            try {
                /*get the value json data com from url
                  return value from  OpenMoviesUtils class
                   by parseing   json data  into it */
                return OpenUtils.getMovies(NetworkUtils
                        .getResponseFromHttpUrl(moviesRequestUrl));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<MovieData> resultArrayList) {
            moviesArrayList = resultArrayList;
            mMovieAdapter.addMovieArrayList(moviesArrayList);
            mMovieAdapter.notifyDataSetChanged();
            pdLoading.dismiss();
        }
    }

}