package booking;

import cinema.*;
import movies.*;
import user.*;

import java.util.Scanner;

public class BookingApp{
	public static void main(String[] args) {
		BookingDatabase bd = new BookingDatabase();
		UserDatabase udb = new UserDatabase();
		TicketPriceCalculator tpc = new TicketPriceCalculator();
		HolidayDatabase hols = new HolidayDatabase();
		User user; 
		ShowTime st;
		int[] seat;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username: ");
		String username = sc.nextLine();
		
		//user database, username, user, tpc, st, holiday, seat
		//bd.addNewBooking(udb, username, user, tpc, st, hols, seat);
		
	}

}
