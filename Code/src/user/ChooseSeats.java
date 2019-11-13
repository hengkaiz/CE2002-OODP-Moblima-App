package user;

import Cinema.ShowTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ChooseSeats {
	private ShowTime st;

	public ChooseSeats(ShowTime st){
		this.st = st;
	}

	public void printSeats(){
		st.getSeatplan().printSeats();
	}

	public void selectSeat(int row, int col, String username){
		if (st.getSeatplan().checkSeat(row, col) == false){// seat taken
			//add exception here
		}
		else{
			st.getSeatplan().assignSeat(row, col, username);
		}
	}
}
