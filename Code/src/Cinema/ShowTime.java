package Cinema;
import Movie.Movie;

import java.util.ArrayList;

public class ShowTime implements Comparable<ShowTime>{
    private int timing;
    private Movie movie;
    private int cinemaNum;
    private seatPlan seatplan;
    private int date;

    public ShowTime(int t, Movie m, int c){
        timing = t;
        movie = m;
        cinemaNum = c;
        seatplan = new seatPlan();
    }
    public ShowTime(){}

    public int getTiming(){ return timing; } //return timing

    public int getDate(){ return date; } //return date

    public String getMovie(){ return movie.getTitle(); } // return movie name

    //compare the different showtimes by timing, need to add function to search in the same cinema
    public int compareTo(ShowTime o) {
        int compareTiming = ((ShowTime) o).timing;
        return this.timing - compareTiming;
    }
}
