package user;

import Cinema.ShowTime;

import java.util.Scanner;

public class ChooseSeats{
	private ShowTime st;

	private ChooseSeats(ShowTime st){
		this.st = st;
	}

	private void printSeats(){
		st.getSeatplan().printSeats();
	}

	private void selectSeat(int row, int col, String username){
		if (st.getSeatplan().checkSeat(row, col) == false){// seat taken
			//add exception here
		}
		else{
			st.getSeatplan().assignSeat(row, col, username);
		}
	}

	public void chooseSeats(String ID) {
		Scanner sc = new Scanner(System.in);
		//BookingDatabase bk = new BookingDatabase();
		printSeats();
		System.out.print("Select row: ");
		int row = sc.nextInt();
		System.out.print("Select column: "); //need to add exception for choosing the wrong seats
		int col = sc.nextInt();
		selectSeat(row, col, ID); //need to add exception choosing a taken seat
	}
}
