package Cinema;
import Movies.Movie;
import Database.getDate;
import java.util.Calendar;

public class ShowTime implements Comparable<ShowTime>{
    private int timing;
    private Movie movie;
    private int cinemaNum;
    private String cinemaType;
    private seatPlan seatplan;
    private Calendar date;
    private MovieFormat movieformat;

    public ShowTime(int t, Movie m, int noOfDaysFromCurrent, int c, MovieFormat f){
        timing = t;
        movie = m;
        getDate d = new getDate();
        date.set(d.getYear(), d.getMonth(), d.getDay() + noOfDaysFromCurrent); //year, month date
        cinemaNum = c;
        seatplan = new seatPlan();
        movieformat = f;
    }
    public ShowTime(){}

    public int getCinemaNum() {
		return cinemaNum;
	}
	public void setCinemaNum(int cinemaNum) {
		this.cinemaNum = cinemaNum;
	}
	public seatPlan getSeatplan() {
		return seatplan;
	}
	public void setSeatplan(seatPlan seatplan) {
		this.seatplan = seatplan;
	}
	public void setTiming(int timing) {
		this.timing = timing;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public int getTiming(){ return timing; } //return timing

    public Calendar getDate(){ return date; } //return date

    public String getMovie(){ return movie.getMovieTitle(); } // return movie name

    public MovieFormat getMovieformat() {
		return movieformat;
	}
	public void setMovieformat(MovieFormat movieformat) {
		this.movieformat = movieformat;
	}
	//compare the different showtimes by timing, need to add function to search in the same cinema
    public int compareTo(ShowTime o) {
        int compareTiming = ((ShowTime) o).timing;
        return this.timing - compareTiming;
    }
}
