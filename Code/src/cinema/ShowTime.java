package cinema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;

import moblima.SaveAndLoadDB;
import movies.Movie;

public class ShowTime implements Comparable<ShowTime>, Serializable{
    private int timing;
    private Movie movie;
    private Cinema assignedCinema;
    private SeatPlan seatPlan;
    private Calendar date;
    private MovieFormat movieFormat;

    public ShowTime(int t, Movie m, int noOfDaysFromCurrent, int cineplexNum, int cinemaNum, MovieFormat f){
        timing = t;
        movie = m;
        date = Calendar.getInstance(); //year, month, date
		date.add(Calendar.DAY_OF_MONTH, noOfDaysFromCurrent); //add future movies

		SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
		Cineplex cdb = saveAndLoadDB.loadCineplex(cineplexNum);

		for (Cinema c: cdb.getCinemas()){
			if (c.getCinemaNumber() == cinemaNum){
				this.assignedCinema = c;
				break;
			}
		}

        seatPlan = new SeatPlan();
        movieFormat = f;
    }
    public ShowTime(){}

    public void setCinemaNum(int num){
    	this.assignedCinema.setCinemaNumber(num);
	}

    public String getCinemeCode(){ return this.assignedCinema.getCode();}

    public int getCinemaNum() {
		return this.assignedCinema.getCinemaNumber();
	}
    
	public String getCinemaType() {
		return this.assignedCinema.getType();
	}

	public void setSeatplan(SeatPlan seatplan) {
		this.seatPlan = seatplan;
	}

	public SeatPlan getSeatplan() {
		return seatPlan;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getMovie(){ 
		return movie.getMovieTitle(); 
	} // return movie name

	public void setTiming(int timing) {
		this.timing = timing;
	}

	public int getTiming(){
		return timing;
	} //return timing
	
	public String timeToString() {
		String fourDigits = String.format("%04d", this.timing);
		return fourDigits;
	}
	
    public String toStringGetDate(){ //return date in dd/MM format
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
		String d = sdf.format(date.getTime());
		return d;
	}

    public Calendar getDate(){
		return date;
	}

    public MovieFormat getMovieformat() {
		return movieFormat;
	}
    
    public Movie getMovieObject() {
    	return this.movie;
    }

	public void setMovieformat(MovieFormat movieformat) {
		this.movieFormat = movieformat;
	}

	//compare the different showtimes by timing, need to add function to search in the same cinema
    public int compareTo(ShowTime o) {
        int compareTiming = ((ShowTime) o).timing;
        return this.timing - compareTiming;
    }
}
