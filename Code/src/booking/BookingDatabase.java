package booking;
import cinema.*;
import movies.*;
import user.*;

import java.io.Serializable;
import java.util.ArrayList;

public class BookingDatabase extends UserDatabase implements Serializable{
	private ArrayList<BookingDetails> BookingDetailsList = new ArrayList<BookingDetails>();
	private ArrayList<BookingDetails> copybook = null;

	public BookingDatabase() {

	}

	public ArrayList<BookingDetails> getBookingDetails(String username, ShowTime st, int[] seat) {

		if (BookingDetailsList.size() == 0)
			System.out.println("There are no records in the database.");

		for (BookingDetails details: BookingDetailsList) {
			if (details.getMoviegoerName().equals(username)) {
				copybook.add(details);
			}
			else
				System.out.println("Sorry! No booking is done under your name.");
		}
		return copybook;
	}

	//user database, username, tpc, st, holiday, seat
	public void addNewBooking(UserDatabase udb, String username, TicketPriceCalculator calculator,
							  ShowTime st, HolidayDatabase holiday, int[] seat, Cinema cinema){

		String email = null;
		int mobile = 0;
		double price = 0;
		String name = null;

		Transaction TID = new Transaction();
		BookingDetails details = new BookingDetails(username, st, seat, calculator);

		for (User usr:udb.getUserList()) {
			if (usr.getUsername().equals(username)) {
				email = usr.getEmail();
				mobile = usr.getMobile();
				price = calculator.calculatePrice(usr, st, holiday);
				name = usr.getName();
			}

			else
				System.out.println("User is not in database!");
		}

		details.setmoviegoerName(name);
		details.setShowtime(st);
		details.setEmailAddress(email);
		details.setMobileNumber(mobile);
		details.setSeat(seat);
		details.setTicketPrice(price);
		details.setTID(TID.makeTID(username, cinema));

		BookingDetailsList.add(details);
	}
}

