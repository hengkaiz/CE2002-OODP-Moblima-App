package user;

import Booking.*;
import Cinema.ShowTime;

import java.util.ArrayList;
import java.util.Scanner;

public class UserFunctions{
	private User login_user;
	//checking username and password entered
	private boolean loginCheck(String name, String password){
		UserDatabase udb = new UserDatabase();
		login_user = udb.searchByName(name);
		//code in exception here if username not found

		if (login_user.getPassword() != password){
			return false;
		}
		return true;
	}

	public boolean login(String name, String password){
		return loginCheck(name, password);
	}

	public void chooeSeats(ShowTime st) {
		Scanner sc = new Scanner(System.in);
		ChooseSeats cs = new ChooseSeats(st);
		BookingDatabase bk = new BookingDatabase();
		cs.printSeats();
		System.out.print("Select row: ");
		int row = sc.nextInt();
		System.out.print("Select column: "); //need to add exception for choosing the wrong seats
		int col = sc.nextInt();
		cs.selectSeat(row, col, login_user.getName()); //need to add exception choosing a taken seat

		bk.addNewBooking(login_user.getName(), st, row, col);
	}
}
