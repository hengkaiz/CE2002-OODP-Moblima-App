package Movie;
import java.util.ArrayList;

public class Movie {
    private String title;
    private String type;
    private ArrayList<MovieReview> reviews;
    private String status;
    private String agelimit;
    private int runtime;

    public Movie(String title, String type, String status,
                 String agelimit, int runtime){
        this.title = title;
        this.type = type;
        this.reviews = new ArrayList<MovieReview>();
        this.status = status;
        this.agelimit = agelimit;
        this.runtime = runtime;
    }

    public String getTitle(){
        return title;
    }
}
