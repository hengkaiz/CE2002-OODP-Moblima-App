package Booking;
import Cinema.*;

import java.util.ArrayList;

public class BookingDatabase {
	 private ArrayList<BookingDetails> BookingDetailsList = new ArrayList<BookingDetails>();
	 private ArrayList<BookingDetails> copybook;
	 
	 public BookingDatabase() {
		 BookingDetails bk = new BookingDetails("heop", 555, "h", 7, 9, 17, 17.8);
		 BookingDetailsList.add(bk);
	 }
	 
	 private void getBookingDetails(String name) { 
		 copybook = new ArrayList<BookingDetails>();
		 for (BookingDetails details: BookingDetailsList) {
			 if (details.getmoviegoerName().equals(name)) {
				 //System.out.println(details.getbaseticketPrice());
				 System.out.println(details.getemailAddress());
				 System.out.println(details.getmobileNumber());
				 System.out.println(details.getmoviegoerName());
				 System.out.println(details.getshowtime());
				 //copybook.add(details.getmobileNumber());
				 
			 }
		 }
	 }
}

