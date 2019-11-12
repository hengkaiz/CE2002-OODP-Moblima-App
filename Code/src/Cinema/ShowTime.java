package Cinema;
import Movie.Movie;
import Database.getDate;

import java.util.Calendar;

public class ShowTime implements Comparable<ShowTime>{
    private int timing;
    private Movie movie;
    private int cinemaNum;
    private seatPlan seatplan;
    private Calendar date;

    public ShowTime(int t, Movie m, int noOfDaysFromCurrent, int c){
        timing = t;
        movie = m;
        getDate d = new getDate();
        date.set(d.getYear(), d.getMonth(), d.getDay() + noOfDaysFromCurrent); //year, month date
        cinemaNum = c;
        seatplan = new seatPlan();
    }
    public ShowTime(){}

    public int getTiming(){ return timing; } //return timing

    public Calendar getDate(){ return date; } //return date

    public String getMovie(){ return movie.getTitle(); } // return movie name

    //compare the different showtimes by timing, need to add function to search in the same cinema
    public int compareTo(ShowTime o) {
        int compareTiming = ((ShowTime) o).timing;
        return this.timing - compareTiming;
    }
}
