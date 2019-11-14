package booking;
import cinema.*;
import user.*;
import movies.*;

import java.util.ArrayList;

public class BookingDatabase extends UserDatabase{
	 private ArrayList<BookingDetails> BookingDetailsList = new ArrayList<BookingDetails>();
	 private ArrayList<BookingDetails> copybook;
	 
	 public BookingDatabase() {

	 }
	 
	 //username, name, mobile, email, ID, showtime, seatno, price
	 public void getBookingDetails(String username) { 
		 copybook = new ArrayList<BookingDetails>();
		 
		 if (BookingDetailsList.size() == 0)
			 System.out.println("There are no records in the database.");
		 
		 for (BookingDetails details: BookingDetailsList) {
			 if (details.getuserName().equals(username)) {
				 System.out.println("Hello " + username + ", here are your current bookings.");
				 System.out.println("Name: " + details.getmoviegoerName());
				 System.out.println("Mobile number: " + details.getmobileNumber());
				 System.out.println("Email address: " + details.getemailAddress());
				 System.out.println("Showtime: " + details.getshowtime());
				 System.out.println("Seat Row: " + details.getseatRow());
				 System.out.println("Seat Column: " + details.getseatCol());
				 System.out.println("Ticket price: " + details.getticketPrice());
			 }
			 
			 else 
				 System.out.println("Sorry! No booking is done under your name.");
		 }
	 }
	 
	 //username, name, mobile, email, showtime, seatrow, seatcol, price
	 public void addNewBooking(String username, ShowTime st, int row, int col){
		 String email = null;
		 int mobile = 0;
		 double price = 0;	
		 String name = null;
		 
		 ArrayList<User> userlist = new ArrayList<User>();
		 BookingDetails deets = new BookingDetails(username, name, mobile, email, st, row, col, price);
		 TicketPriceCalculator calc = new TicketPriceCalculator();
		 HolidayDatabase hols = new HolidayDatabase();
		 
		 for (User usr: userlist) {
			 if (usr.getUsername().equals(username)) {
				 email = usr.getEmail();
				 mobile = usr.getMobile();
				 price = calc.calculatePrice(usr, st, hols);
				 name = usr.getName();
			 }	 
		 }
		 
		 deets.setmoviegoerName(name); 
		 deets.setshowtime(st);
		 deets.setemailAddress(email);
		 deets.setmobileNumber(mobile);
		 deets.setshowtime(st);
		 deets.setseatRow(row);
		 deets.setseatCol(col);
		 deets.setticketPrice(price);
		 
		 BookingDetailsList.add(deets);
	 }
}

