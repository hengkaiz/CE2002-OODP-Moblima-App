package booking;
import cinema.*;
import movies.*;
import user.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * represents the booking database
 *
 */
public class BookingDatabase implements Serializable{
	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * instantiation of the BookingDetailList object
	 */
	private ArrayList<BookingDetails> BookingDetailsList = new ArrayList<BookingDetails>();
	/**
	 * this constructs a BookingDatabase object for the BookingDatabase class
	 */

	public BookingDatabase() {

	}
	/**
	 * checks username against the booking database and returns all the bookings under the username
	 * @param username input for user's username
	 * @return all of user's BookingDetails stored in a list
	 */
	public ArrayList<BookingDetails> getBookingDetails(String username) {
		ArrayList<BookingDetails> copybook = new ArrayList<BookingDetails>();
		if (BookingDetailsList.size() == 0) {
			System.out.println("Sorry! No booking is done under your name.");
			return null;
		}

		for (BookingDetails details: BookingDetailsList) {
			if (details.getUsername().equals(username)) {
				copybook.add(details);
			}
		}
		if(copybook.size() == 0) System.out.println("Sorry! No booking is done under your name.");
		return copybook;
	}
	/**
	 * adds in a new booking to the booking database, using username, cineplex number, showtime, seat and price as parameters
	 * @param username input for user's username
	 * @param cineplexNum input for cineplex's number
	 * @param st input for showtime
	 * @param seat input for seat selected
	 * @param price input for ticket price
	 */

	public void addNewBooking(String username, int cineplexNum, ShowTime st, int[] seat, double price){

		Transaction TID = new Transaction();
		String TIDcode = TID.makeTID(username, st);

		BookingDetails details = new BookingDetails(username, cineplexNum, st, seat, price, TIDcode);

		BookingDetailsList.add(details);
	}
}

