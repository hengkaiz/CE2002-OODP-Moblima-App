package Movie;
import java.util.ArrayList;

public class Movie {
    private String title;
    private MovieType type;
    private ArrayList<MovieReview> reviews;
    private MovieStatus status;
    private AgeLimit agelimit;
    private int runtime;

    public Movie(String title, MovieType type, MovieReview reviews, MovieStatus status,
                 AgeLimit agelimit, int runtime){
        this.title = title;
        this.type = type;
        this.reviews = new ArrayList<MovieReview>();
        this.status = status;
        this.agelimit = agelimit;
        this.runtime = runtime;
    }
}
