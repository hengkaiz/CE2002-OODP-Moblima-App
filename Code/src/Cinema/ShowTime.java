package Cinema;
import Movie.Movie;

import java.util.ArrayList;

public class ShowTime implements Comparable<ShowTime>{
    private int timing;
    private Movie movie;
    private seatPlan seatplan;

    public ShowTime(int t, Movie m){
        timing = t;
        movie = m;
        seatplan = new seatPlan();
    }

    public int getTiming(){ return timing; } //return timing

    public Movie getMovie(){ return movie; } // return movie name

    //compare the different parameters to sort by time, movie, etc..
    public int compareTo(ShowTime o) {
        return 0;
    }
}
