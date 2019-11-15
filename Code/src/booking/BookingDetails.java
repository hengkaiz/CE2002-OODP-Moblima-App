package booking;

import java.io.Serializable;

import cinema.*;
import user.*;
import movies.*;


public class BookingDetails implements Serializable{
	private String moviegoerName; 
	private int mobileNumber;
	private String emailAddress;
	private ShowTime showtime;
	private double ticketPrice;
	private String username;
	private int[] Seat;
	private String TID;                                                           
	private int cineplexNum;
	private int cinemaNum;

	 //name, mobile, email, ID, showtime, seatno, price	
	public BookingDetails(String username, ShowTime st, int[] seat, TicketPriceCalculator calculator) {
		//username = user;
		//moviegoerName = name;
		//mobileNumber = mobile;
		//emailAddress = email;
		//showtime = st;
		//ticketPrice = price;
	}

	public String getCineplexNum() {
		if(this.cineplexNum == 1) return "Jurong Point";
		else if(this.cineplexNum == 2) return "Bishan";
		else return "Nex";
	}

	public void setCineplexNum(int cineplexNum) {
		this.cineplexNum = cineplexNum;
	}

	public String getMoviegoerName() {
		return moviegoerName;
	}

	public void setMoviegoerName(String moviegoerName) {
		this.moviegoerName = moviegoerName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ShowTime getShowtime() {
		return showtime;
	}

	public void setShowtime(ShowTime showtime) {
		this.showtime = showtime;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int[] getSeat() {
		return Seat;
	}

	public void setSeat(int[] seat) {
		Seat = seat;
	}

	public String getTID() {
		return TID;
	}

	public void setTID(String TID) {
		this.TID = TID;
	}

	public int getCinemaNum() {
		return cinemaNum;
	}

	public void setCinemaNum(int cinemaNum) {
		this.cinemaNum = cinemaNum;
	}
}
