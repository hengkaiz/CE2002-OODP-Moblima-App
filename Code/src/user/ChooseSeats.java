package user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Cinema.seatPlan;


public class ChooseSeats {
	
	List<List<String>> seats = new ArrayList<List<String>>();
	
	public boolean taken;
	
	public void initializeSeats() {
		for (int i =0; i <seats.length; ++i) {
			for (int j =0; j<seats[i].length; ++j) {
				seats[i][j] = 'O';
			}
		}
	}
	
	
	public void displaySeats() {
		for (int i =0; i <seats.length; ++i) {
			for (int j =0; j<seats[i].length; ++j) {
				System.out.println(seats[i][j]);
			}
		}
	}
	
	public void ChooseSeats() {
		System.out.println("The seats marked 'O' are empty, 'X' are occupied");
		System.out.println("---------SCREEN----------");
		displaySeats();
		System.out.println("Please enter the row of desired seat");
		Scanner sc = new Scanner(System.in);
		int selectRow = sc.nextInt();
		System.out.println("Please enter the column of desired seat");
		int selectColumn = sc.nextInt();
		if (this.seats[selectRow][selectColumn] != 'X') {
			this.seats[selectRow][selectColumn] = 'X';
		}
		else {
			System.out.println("Sorry seat has already been taken");
		}
		
	}
	
	
}
