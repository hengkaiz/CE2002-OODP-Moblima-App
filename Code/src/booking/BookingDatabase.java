package booking;
import cinema.*;
import movies.*;
import user.*;

import java.io.Serializable;
import java.util.ArrayList;

public class BookingDatabase implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<BookingDetails> BookingDetailsList = new ArrayList<BookingDetails>();
	private ArrayList<BookingDetails> copybook = null;

	public BookingDatabase() {

	}

	public ArrayList<BookingDetails> getBookingDetails(String username) {

		if (BookingDetailsList.size() == 0)
			System.out.println("There are no records in the database.");

		for (BookingDetails details: BookingDetailsList) {
			if (details.getUsername().equals(username)) {
				copybook.add(details);
			}
			else
				System.out.println("Sorry! No booking is done under your name.");
		}
		return copybook;
	}

	//user database, username, tpc, st, holiday, seat
	public void addNewBooking(String username, int cineplexNum, ShowTime st, int[] seat, double price){

		Transaction TID = new Transaction();
		String TIDcode = TID.makeTID(username, st);

		BookingDetails details = new BookingDetails(username, cineplexNum, st, seat, price, TIDcode);

		BookingDetailsList.add(details);
	}
}

