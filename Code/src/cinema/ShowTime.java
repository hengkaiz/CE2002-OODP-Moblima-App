package cinema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;

import moblima.SaveAndLoadDB;
import movies.Movie;
/**
 *represents the showtime 
 *
 */
public class ShowTime implements Comparable<ShowTime>, Serializable{
	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * timing the movie is showing at
	 */
	private int timing;
	/**
	 * the movie details in the Movie object form
	 */
    private Movie movie;
    /**
     * the assigned cinema in the Cinema object form 
     */
    private Cinema assignedCinema;
    /**
     * the seat plan in the SeatPlan object form
     */
    private SeatPlan seatPlan;
    /**
     * the dates in Calender object form
     */
    private Calendar date;
    /**
     * the movie format in the MovieFormat object form
     */
    private MovieFormat movieFormat;
    /**
     * constructs a ShowTime object for the ShowTime class, using the timing, movie, days from current, cineplex's number, cinema's number and movie format as parameters.
     * @param t input for time the movie is showing at
     * @param m input for the movie in Movie object form
     * @param noOfDaysFromCurrent input for the number of days from current day the movie shows at
     * @param cineplexNum input for the cineplex's number
     * @param cinemaNum input for the cinema's number
     * @param f input for the movie's format in the MovieFormat object form
     */
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
    /**
     * constructs a ShowTime object for the ShowTime class
     */
    public ShowTime(){}
    /**
     * 
     * @param num cinema number to set
     */
    public void setCinemaNum(int num){
    	this.assignedCinema.setCinemaNumber(num);
	}
    /**
     * 
     * @return current cinema's code
     */

    public String getCinemeCode(){ return this.assignedCinema.getCode();}
    
    /**
     * 
     * @return current cinema's number
     */
    public int getCinemaNum() {
		return this.assignedCinema.getCinemaNumber();
	}
    /**
     * 
     * @return current cinema's type
     */
	public String getCinemaType() {
		return this.assignedCinema.getType();
	}
	/**
	 * @return get current assigned cinema
	 */
	public Cinema getAssignedCinema() {
		return assignedCinema;
	}
	/**
	 * @param assignedCinema assigned cinema to set
	 */
	public void setAssignedCinema(Cinema assignedCinema) {
		this.assignedCinema = assignedCinema;
	}
	/**
	 * 
	 * @param seatPlan seat plan to set
	 */

	public void setSeatPlan(SeatPlan seatPlan) {
		this.seatPlan = seatPlan;
	}
	/**
	 * 
	 * @return current seat plan
	 */
	public SeatPlan getSeatPlan() {
		return seatPlan;
	}
	/**
	 * 
	 * @param movie movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	/**
	 * 
	 * @return current movie
	 */
	public String getMovie(){ 
		return movie.getMovieTitle(); 
	} // return movie name
	/**
	 * 
	 * @param timing timing to set
	 */
	public void setTiming(int timing) {
		this.timing = timing;
	}
	/**
	 * 
	 * @return current timing
	 */
	public int getTiming(){
		return timing;
	} //return timing
	/**
	 * converts the 4 digits timing to string format
	 * @return timing in String format
	 */
	public String timeToString() {
		String fourDigits = String.format("%04d", this.timing);
		return fourDigits;
	}
	/**
	 * return date in dd/MM format
	 * @return date
	 */
	
    public String toStringGetDate(){ 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
		String d = sdf.format(date.getTime());
		return d;
	}
    /**
     * 
     * @return current date
     */
    public Calendar getDate(){
		return date;
	}
    /**
     * 
     * @return current movie format
     */
    public MovieFormat getMovieFormat() {
		return movieFormat;
	}
    /**
     * 
     * @return current movie object
     */
    public Movie getMovieObject() {
    	return this.movie;
    }
    /**
     * sets the movie format
     * @param movieFormat movieFormat to set
     */
	public void setMovieFormat(MovieFormat movieFormat) {
		this.movieFormat = movieFormat;
	}
	/**
	 * compare the different showtimes by timing
	 */
    public int compareTo(ShowTime o) {
        int compareTiming = ((ShowTime) o).timing;
        return this.timing - compareTiming;
    }
}
