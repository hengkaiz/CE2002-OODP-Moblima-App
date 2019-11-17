package booking;

import java.io.Serializable;

import cinema.*;
import user.*;
import movies.*;

/**
 *represents the booking details 
 *
 */
public class BookingDetails implements Serializable {
	/**
	 * Allows saving and loading of the actual database to and from a local copy
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * user's username
	 */
	private String username;
	/**
	 * cineplex's name
	 */
    private String cineplexName;
    /**
     * cinema's number
     */
    private int cinemaNum;
    /**
     * movie's title
     */
    private String movieTitle;
    /**
     * date 
     */
    private String date;
    /**
     * showtime
     */
    private int showTime;
    /**
     * seat
     */
    private int[] seat;
    /**
     * the price of tickets
     */
    private double price;
    /**
     * transaction ID
     */
    private String TID;
    /**
     * constructs a BookingDetails object for the BookingDetails class, based on the cineplexes. it uses username, cineplex number, showtime, seat, price and transaction ID as parameters
     * @param username input for user's username
     * @param cineplexNum input for cineplex's number
     * @param st input for showtime
     * @param seat input for seat
     * @param price input for ticket price
     * @param TID input for transaction ID
     */
    public BookingDetails(String username, int cineplexNum, ShowTime st,
                          int[] seat, double price, String TID) {
        this.username = username;

        //set the cineplex based on its number
        if (cineplexNum == 1) cineplexName = "Jurong Point";
        else if (cineplexNum == 2) cineplexName = "Bishan";
        else this.cineplexName = "Nex";

        this.date = st.toStringGetDate();
        this.cinemaNum = st.getCinemaNum();
        this.movieTitle = st.getMovie();
        this.showTime = st.getTiming();
        this.seat = seat;
        this.price = price;
        this.TID = TID;
    }
    /**
     * 
     * @return current date
     */
    public String getDate() {
        return date;
    }
    /**
     * 
     * @param date date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * 
     * @return current price
     */
    public double getPrice() {
        return price;
    }
    /**
     * 
     * @param price price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * 
     * @return current transaction ID
     */
    public String getTID() {
        return TID;
    }
    /**
     * 
     * @param TID TID to set
     */
    public void setTID(String TID) {
        this.TID = TID;
    }	
    /**
     * 
     * @return current usersame
     */
    public String getUsername() {
        return username;
    }
    /**
     * 
     * @param username username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 
     * @return current cineplex's name
     */
    public String getCineplexName() {
        return cineplexName;
    }
    /**
     * 
     * @param cineplexName cineplex's name to set
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }
    /**
     * 
     * @return current cinema number
     */
    public int getCinemaNum() {
        return cinemaNum;
    }
    /**
     * 
     * @param cinemaNum cinema's number to set
     */
    public void setCinemaNum(int cinemaNum) {
        this.cinemaNum = cinemaNum;
    }
    /**
     * 
     * @return current movie title
     */
    public String getMovieTitle() {
        return movieTitle;
    }
    /**
     * 
     * @param movieTitle movie title to set
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    /**
     * 
     * @return current show time
     */
    public int getShowTime() {
        return showTime;
    }
    /**
     * 
     * @param showTime showtime to set
     */
    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }
    /**
     * 
     * @return current seat
     */
    public int[] getSeat() {
        return seat;
    }
    /**
     * 
     * @param seat seat to set
     */
    public void setSeat(int[] seat) {
        this.seat = seat;
    }
}





































































































