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

	 //name, mobile, email, ID, showtime, seatno, price	
	public BookingDetails(String username, ShowTime st, int[] seat, TicketPriceCalculator calculator) {
		//username = user;
		//moviegoerName = name;
		//mobileNumber = mobile;
		//emailAddress = email;
		//showtime = st;
		//ticketPrice = price;
	}
	
	//getting functions
	public String getuserName() {
		return this.username;
	}
	
	public String getmoviegoerName() {
		return this.moviegoerName;
	}
	
	public int getmobileNumber() {
		return this.mobileNumber;
	}
	
	public String getemailAddress() {
		return this.emailAddress;
	}
	
	public ShowTime getshowtime(ShowTime st) {
		return st;
	}
	
	public double getticketPrice() {
		return ticketPrice;
	}
	
	public int[] getSeat(int[] seat) {
		return seat;
	}
	
	public String getTID() {
		return TID;
	}
	//setting functions
	public void setuserName(String username) { 
		this.username = username;
	}
	
	public void setmoviegoerName(String moviegoerName) {
		this.moviegoerName = moviegoerName;
	}
	
	public void setmobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public void setemailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setshowtime(ShowTime st) {
		this.showtime = st;
	}
	
	public void setticketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	public void setSeat(int[] seat) {
		this.Seat = seat; 
	}
	
	public void setTID(String TID) {
		this.TID = TID;
	}
}
