package Booking;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingApp {
	public static void main(String[] args) {
		BookingDatabase bd = new BookingDatabase();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		
		bd.getBookingDetails(name);	
	}

}
