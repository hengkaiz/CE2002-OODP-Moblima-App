package user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import Cinema.ShowTime;
import Database.*;
import movies.MovieDatabase;

public class SearchByDate extends ShowTimeDatabase implements SearchFunction {
	private Calendar date;
	private Calendar copydate;
	private ArrayList<ShowTime> showtimes;
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
			copydate.add(Calendar.DAY_OF_MONTH, 1);
			output = sdf.format(copydate.getTime()); //converts it to dd/MM format
			System.out.printf("%d. %s\n", i+1, output);
		}
		choice = sc.nextInt() -1;

		date.add(Calendar.DAY_OF_MONTH, choice);
		output = sdf.format(date.getTime());
		showtimes = super.searchByDate(output); //get an array of showtime on that date
	}

	public ArrayList<ShowTime> searchApp(MovieDatabase mb) {
		System.out.println("---Search By Movie---");
		this.mb = mb;
		searchResult(); //get show time for that date

		return showtimes;
	}
}
