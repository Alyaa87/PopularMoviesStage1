package com.example.android.popularmoviesstage1;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieData implements Parcelable {
    public String poster_image;
    public String original_title;
    private long votAverage;
    private String overview;
    private String releaseDate;

    public MovieData(Parcel in) {
        poster_image = in.readString();
        original_title = in.readString();
        votAverage = in.readLong();
        overview = in.readString();
        releaseDate = in.readString();
    }

    public static final Creator<MovieData> CREATOR = new Creator<MovieData>() {
        @Override
        public MovieData createFromParcel(Parcel in) {
            return new MovieData(in);
        }

        @Override
        public MovieData[] newArray(int size) {
            return new MovieData[size];
        }
    };

    public MovieData() {
    }

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

    @Override
    public int describeContents() {
        return 0;
    }
    // write the values we want to save to the `Parcel`.
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(releaseDate);
        parcel.writeString(original_title);
        parcel.writeString(overview);
        parcel.writeLong(votAverage);
        parcel.writeString(poster_image);

    }
}