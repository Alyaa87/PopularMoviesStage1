package com.example.android.popularmoviesstage1;

public class MovieData {
    public String poster_image;
    public String original_title;
    private long votAverage;
    private String overview;
    private String releaseDate;

    //getter and setter methods.

    public long getVotAverage() {
        return votAverage;
    }
    public void setVotAverage(long votAverage) {
        this.votAverage = votAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_image() {
        return poster_image;
    }

    public void setPoster_image(String poster_image) {
        this.poster_image = poster_image;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
}