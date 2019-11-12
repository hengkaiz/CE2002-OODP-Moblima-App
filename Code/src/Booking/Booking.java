package Booking;

import java.util.ArrayList;

import Cinema.*;
import Movies.*;

public class Booking {
	
	public void getSeatPlan(){
		//prints out the current seat plan for the user to choose seats
		seatPlan seatplan = new seatPlan();
		seatplan.printSeats();
	}
	
	public double getPrice(){
		//get ticket price from database?
		return 0;
	}
	
	public void updateBookingDatabase() {
		//update the booking database
		
	}
}
