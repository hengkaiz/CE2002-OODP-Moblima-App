package user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import cinema.ShowTime;
import cinema.ShowTimeDatabase;
import movies.MovieDatabase;

public class UserSearchByDate extends ShowTimeDatabase implements UserSearchFunction {
	private Calendar date;
	private Calendar copydate;
	private ArrayList<ShowTime> showtimes = null;
	private MovieDatabase mb;

	public void searchResult() {
		Scanner sc = new Scanner(System.in);
		int choice;
		String output;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");

		//gets the date
		copydate = Calendar.getInstance();
		date = Calendar.getInstance();

		//prints out dates of next 5 days
		System.out.println("Select Date:");
		for(int i=0; i<5; i++) {
			output = sdf.format(copydate.getTime()); //converts it to dd/MM format
			System.out.printf("%d. %s\n", i+1, output);
			copydate.add(Calendar.DAY_OF_MONTH, 1);
		}
		System.out.println("-1 to return");
		System.out.print("Please select Date: ");
		try {
			choice = sc.nextInt();

			if (choice == -1) return;
			date.add(Calendar.DAY_OF_MONTH, choice-1);
			output = sdf.format(date.getTime());
			showtimes = super.searchByDate(output); //get an array of showtime on that date
		} catch (Exception e) {
			System.out.println("Invalid Date. Try Again.");
		}
	}

	public ArrayList<ShowTime> searchApp(MovieDatabase mb) {
		System.out.println("---Search By Date---");
		this.mb = mb;
		searchResult(); //get show time for that date

		return showtimes;
	}
}
