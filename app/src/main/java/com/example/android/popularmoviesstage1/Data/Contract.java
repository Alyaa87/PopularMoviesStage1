package com.example.android.popularmoviesstage1.Data;

import com.example.android.popularmoviesstage1.BuildConfig;

public class Contract {

    private static final String KEY = "?api_key=";
    /* information. Each Movies info is an element of the "results" array */
    public static final String RESULTS = "results";
    /*all  children objects in "results" array */
    public static final String VOTE_AVERAGE = "vote_average";
    public static final String POSTER_PATH = "poster_path";
    public static final String OVERVIEW = "overview";
    public static final String RELEASE_DATE = "release_date";
    public static final String TITLE = "title";

    //TODO put your own Api key here
    public static final String API_KEY = KEY+ BuildConfig.API_KEY;

    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String POPULAR_PART = "popular";
    public static final String TOP_RATED_PART = "top_rated";
    //keys of the intent bundle
    public static final String EXTRA_TITLE = "extra_title ";
    public static final String EXTRA_URL = "extra_url ";
    public static final String EXTRA_YEAR = "extra_year ";
    public static final String EXTRA_RATE = "extra_rate ";
    public static final String EXTRA_OVERVIEW = "extra_overview";
    //the url of value of image view
    public static final String IMAGE_URL = "http://image.tmdb.org/t/p/";
    public static final String W185 = "w185";
    public static final String W500 = "w500";
    public static final String W780 = "w780";

}