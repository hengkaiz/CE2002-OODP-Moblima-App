package booking;
import cinema.*;
import movies.*;
import user.*;

import java.util.ArrayList;

public class BookingDatabase extends UserDatabase{
	 private ArrayList<BookingDetails> BookingDetailsList = new ArrayList<BookingDetails>();
	 private ArrayList<BookingDetails> copybook;
	 
	 public BookingDatabase() {

	 }
	 
	 public void getBookingDetails(User user, String username, ShowTime st, int[] seat) { 
		 copybook = new ArrayList<BookingDetails>();
		 
		 if (BookingDetailsList.size() == 0)
			 System.out.println("There are no records in the database.");
		 
		 for (BookingDetails details: BookingDetailsList) {
			 if (details.getuserName().equals(username)) {
				 System.out.println("Hello " + username + ", here are your current bookings.");
				 System.out.println("Name: " + details.getmoviegoerName());
				 System.out.println("Mobile number: " + details.getmobileNumber());
				 System.out.println("Email address: " + details.getemailAddress());
				 System.out.println("Showtime: " + details.getshowtime(st));
				 System.out.println("Seats chosen: " + details.getSeat(seat));
				 System.out.println("Ticket price: " + details.getticketPrice());
			 }
			 
			 else 
				 System.out.println("Sorry! No booking is done under your name.");
		 }
	 }
	 
	 //user database, username, user, tpc, st, holiday, seat
	 public void addNewBooking(UserDatabase udb, String username, TicketPriceCalculator calculator, 
	 ShowTime st, HolidayDatabase holiday, int[] seat){
		 
		 String email = null;
		 int mobile = 0;
		 double price = 0;	
		 String name = null;
		 
		 BookingDetails details = new BookingDetails(username, st, seat, calculator);
		 
		 for (User usr:udb.getUserList()) {
			 if (usr.getUsername().equals(username)) {
				 email = usr.getEmail();
				 mobile = usr.getMobile();
				 price = calculator.calculatePrice(usr, st, holiday);
				 name = usr.getName();
			 }	 
		 }
		 
		 details.setmoviegoerName(name); 
		 details.setshowtime(st);
		 details.setemailAddress(email);
		 details.setmobileNumber(mobile);
		 details.setshowtime(st);
		 details.setSeat(seat);
		 details.setticketPrice(price);
		 
		 BookingDetailsList.add(details);
	 }
}

