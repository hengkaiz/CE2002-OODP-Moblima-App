package booking;

import cinema.*;

public class BookingDetails {
	private String moviegoerName; 
	private int mobileNumber;
	private String emailAddress;
	ShowTime showtime;
	private int seatRow;
	private int seatCol;
	private double ticketPrice;
	private String username;

	 //name, mobile, email, ID, showtime, seatno, price	
	public BookingDetails(String user, String name, int mobile, String email, ShowTime st, int r, int c, double price) {
		username = user;
		moviegoerName = name;
		mobileNumber = mobile;
		emailAddress = email;
		showtime = st;
		seatRow = r;
		seatCol = c;
		ticketPrice = price;
	}
	
	//getting functions
	public String getuserName() {
		return username;
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
	
	public ShowTime getshowtime() {
		return showtime;
	}
	
	public int getseatRow() { 
		return seatRow;
	}
	
	public int getseatCol() {
		return seatCol;
	}
	
	public double getticketPrice() {
		return ticketPrice;
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
		this.showtime = showtime;
	}
	
	public void setseatRow(int r) {
		this.seatRow = r;
	}
	
	public void setseatCol(int c) {
		this.seatCol = c;
	}
	
	public void setticketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
