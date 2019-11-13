package Cinema;
import Movies.Movie;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShowTime implements Comparable<ShowTime>{
    private int timing;
    private Movie movie;
    private int cinemaNum;
    private String cinemaType;
    private SeatPlan seatplan;
    private Calendar date;
    private MovieFormat movieformat;

    public ShowTime(int t, Movie m, int noOfDaysFromCurrent, int c, MovieFormat f){
        timing = t;
        movie = m;
        date = Calendar.getInstance(); //year, month, date
		date.add(Calendar.DAY_OF_MONTH, noOfDaysFromCurrent); //add future movies
        cinemaNum = c;
        seatplan = new SeatPlan();
        movieformat = f;
    }
    public ShowTime(){}

	public void setCinemaNum(int cinemaNum) {
		this.cinemaNum = cinemaNum;
	}

    public int getCinemaNum() {
		return cinemaNum;
	}
    
	public String getCinemaType() {
		return cinemaType;
	}
	
	public void setSeatplan(SeatPlan seatplan) {
		this.seatplan = seatplan;
	}

	public SeatPlan getSeatplan() {
		return seatplan;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMovie(){ return movie.getMovieTitle(); } // return movie name

	public void setTiming(int timing) {
		this.timing = timing;
	}

	public int getTiming(){ return timing; } //return timing

    public String toStringGetDate(){ //return date in dd/MM format
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
		String d = sdf.format(date.getTime());
		return d;
	}

    public Calendar getDate(){
		return date;
	}

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
