package user;

import cinema.ShowTime;
import cinema.ShowTimeDatabase;
import moblima.SaveAndLoadDB;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * print the seating layout of the cinema and allow user to choose a seat to book
 */
public class UserChooseSeatsApp {
	/**
	 * seat number
	 */
	private int st_no;
	/**
	 * Object reference to store local copy of ShowTimeDatabase
	 */
	private ShowTimeDatabase stdb;
	/**
	 * Allows saving and loading of the actual database to and from a local copy.
	 */
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	/**
	 * cineplex number
	 */
	private int cineplexNum;
	/**
	 * UserChooseSeatsApp constructor
	 * @param st is the user's selected showtime
	 * @param cineplexNum is the cineplex that the showtime is showing at
	 */
	public UserChooseSeatsApp(ShowTime st, int cineplexNum){
		this.cineplexNum = cineplexNum;
		this.stdb = saveAndLoadDB.loadShowTimeDB(cineplexNum);
		int n =0;
		for (ShowTime s: stdb.getShowTimes()){
			if (s.getCinemaNum() == st.getCinemaNum()
			&& s.toStringGetDate().contentEquals(st.toStringGetDate())
			&& s.getTiming() == st.getTiming()) break;
			n++;
		}
		st_no = n;
	}
	/**
	 * calls ShowTimeDatabase to print the seating layout of the selected showtime
	 */
	public void printSeats(){
		stdb.getShowTimes().get(st_no).getSeatPlan().printSeats();
	}
	/**
	 * checks if the seat choosen by the user is valid/ available
	 * @param row is the row number of the seat
	 * @param col is the column number of the seat
	 * @param username is the user's username
	 */
	private void selectSeat(int row, int col, String username) throws IndexOutOfBoundsException {
		if (stdb.getShowTimes().get(st_no).getSeatPlan().checkSeat(row, col) == false){// seat taken
			//add exception here if seat is taken
			throw new IndexOutOfBoundsException();
		}
		else{
			stdb.getShowTimes().get(st_no).getSeatPlan().assignSeat(row, col, username);
		}
	}
	/**
	 * allows user to choose the seat for the selected showtime
	 * @param ID is the user's username
	 * @return the row and column of the seat selected
	*/

	public int[] chooseSeats(String ID) {
		Scanner sc = new Scanner(System.in);
		//BookingDatabase bk = new BookingDatabase();
		int row = 0;
		int col = 0;

		try {
			printSeats();
			System.out.print("Select row (A-H): ");
			row = (int) (Character.toLowerCase(sc.next().charAt(0))) - 97;

			System.out.print("Select column (0-9): "); //need to add exception for choosing the wrong seats
			col = sc.nextInt();
			selectSeat(row, col, ID);
		} catch (IndexOutOfBoundsException | InputMismatchException e) {
			System.out.println("Selected seat invalid. Try Again.");
			return null;
		}
		//need to add exception choosing a taken seat

		int [] seat = {row, col};

		saveAndLoadDB.saveShowTimeDB(stdb, cineplexNum);
		return seat;
	}
}
