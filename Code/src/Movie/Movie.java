package Movie;

import java.util.ArrayList;

public class Movie {
    private String title;
    private MovieType type;
    private ArrayList<MovieReviews> reviews;
    private MovieStatus status;
    private AgeLimit agelimit;
    private int runtime;

    public Movie(String title, MovieType type, MovieRview reviews, AgeLimit agelimit
                , int runtime){
        this.title = title;
        this.type = type;
        this.reviews = new ArrayList<MovieReview>();
        this.agelimit = agelimit;
        this.runtime = runtime;
    }
}
