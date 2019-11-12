package user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import Cinema.ShowTime;
import Database.*;

public class SearchByDate implements SearchFunction {
	private Calendar date;
	private Calendar copydate;
	private ArrayList<ShowTime> showtimes;

	public void searchResult() {
		Scanner sc = new Scanner(System.in);
		int choice;
		String output;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");

		//gets the date
		copydate = Calendar.getInstance();
		date = Calendar.getInstance();

		//prints out dates of next 5 days
		for(int i=0; i<5; i++) {
			copydate.add(Calendar.DAY_OF_MONTH, i);
			output = sdf.format(copydate.getTime()); //converts it to dd/MM format
			System.out.printf("%d. %s\n", i+1, output);
		}
		choice = sc.nextInt() -1;

		date.add(Calendar.DAY_OF_MONTH, choice);
		output = sdf.format(date.getTime());
		DataBase db = new DataBase();
		showtimes = db.searchByDate(output); //get an array of showtime with on that date
	}
}
