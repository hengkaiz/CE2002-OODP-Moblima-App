package Booking;
import Cinema.*;

import java.util.ArrayList;

public class BookingDatabase {
	 private ArrayList<BookingDetails> BookingDetailsList = new ArrayList<BookingDetails>();
	 private ArrayList<BookingDetails> copybook;
	 
	 public BookingDatabase() {
		 BookingDetails bk = new BookingDetails("hope", 987654321, "hopesishu", 7, 1900, 17, 8.00);
		 BookingDetailsList.add(bk);
	 }
	 
	 //name, mobile, email, ID, showtime, seatno, price
	 public void getBookingDetails(String name) { 
		 copybook = new ArrayList<BookingDetails>();
		 for (BookingDetails details: BookingDetailsList) {
			 if (details.getmoviegoerName().equals(name)) {
				 System.out.println("Name: " + details.getmoviegoerName());
				 System.out.println("Mobile number: " + details.getmobileNumber());
				 System.out.println("Email address: " + details.getemailAddress());
				 System.out.println("Transaction ID: " + details.getID());
				 System.out.println("Showtime: " + details.getshowtime());
				 System.out.println("Seat Number: " + details.getseatNumber());
				 System.out.println("Ticket price: " + details.getticketPrice());
			 }
			 
			 else 
				 System.out.println("Sorry! No booking is done under your name.");
		 }
	 }

	 public void addNewBooking(String name, ShowTime st, int row, int col){}
}

