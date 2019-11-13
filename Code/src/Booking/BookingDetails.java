package Booking;

import java.util.ArrayList;

import Cinema.ShowTime;

public class BookingDetails {
	private String moviegoerName; 
	private int mobileNumber;
	private String emailAddress;
	private int transactionID;
	private int showtime;
	private int seatNumber;
	private double ticketPrice;

	 //name, mobile, email, ID, showtime, seatno, price	
	public BookingDetails(String name, int mobile, String email, int ID, int st, int seatno, double price) {
		moviegoerName = name;
		mobileNumber = mobile;
		emailAddress = email;
		transactionID = ID;
		showtime = st;
		seatNumber = seatno;
		ticketPrice = price;
	}
	
	//getting functions
	public String getmoviegoerName() {
		return moviegoerName;
	}
	
	public int getmobileNumber() {
		return mobileNumber;
	}
	
	public String getemailAddress() {
		return emailAddress;
	}
	
	public int getID() {
		return transactionID;
	}
	
	public int getshowtime() {
		return showtime;
	}
	
	public int getseatNumber() { 
		return seatNumber;
	}
	
	public double getticketPrice() {
		return ticketPrice;
	}

	//setting functions
	public void setmoviegoerName() {
		this.moviegoerName = moviegoerName;
	}
	
	public void settmobileNumber() {
		this.mobileNumber = mobileNumber;
	}
	
	public void setemailAddress() {
		this.emailAddress = emailAddress;
	}
	
	public void setID() {
		this.transactionID = transactionID;
	}
	
	public void setshowtime() {
		this.showtime = showtime;
	}
	
	public void setseatNumber() { 
		this.seatNumber = seatNumber;
	}
	
	public void setticketPrice() {
		this.ticketPrice = ticketPrice;
	}
}
