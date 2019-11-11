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
	
	public BookingDetails(String name, int mobile, String email, int ID, int st, int seatno, double price) {
		moviegoerName = name;
		mobileNumber = mobile;
		emailAddress = email;
		transactionID = ID;
		showtime = st;
		seatNumber = seatno;
		ticketPrice = price;
	}
	
	public String getmoviegoerName() {
		return moviegoerName;
	}
	
	public int getmobileNumber() {
		return mobileNumber;
	}
	
	public String getemailAddress() {
		return emailAddress;
	}
	
	public int getshowtime() {
		return showtime;
	}
	
	public double getticketPrice() {
		return ticketPrice;
	}

}
