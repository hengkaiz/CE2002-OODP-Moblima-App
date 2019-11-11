package Cinema;
import Movie.Movie;

import java.util.ArrayList;

public class ShowTime implements Comparable<ShowTime>{
    private int timing;
    private Movie movie;
    private int cinemaNum;
    private String cinemaType;
    //private ArrayList<seatPlan> seatPlan;

    public ShowTime(int t, Movie m, int cn, String ct){
        timing = t;
        movie = m;
        cinemaNum = cn;
        cinemaType = ct;
    }

    public int getTiming(){ return timing; } //return movie timing

    public Movie getMovie(){ return movie; } // return movie name

    public int getCinemaNum(){ return cinemaNum; } // return cinema number

    public String getCinemaType(){ return cinemaType; } // return cinema type

    //compare the different parameters to sort by time, movie, etc..
    public int compareTo(ShowTime o) {
        return 0;
    }
}
