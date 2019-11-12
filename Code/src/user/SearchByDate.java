package user;
import java.util.ArrayList;
import java.util.Scanner;
import Database.DataBase;
import Movies.Movie;
import Movies.MovieDatabase;

public class SearchByDate implements SearchFunction {
	private int date;
	private String movie;
	
	
	public void searchbydate() {
		//prints date
        System.out.println("Please select date");
        Scanner sc = new Scanner(System.in);
        int selDate = sc.nextInt();
		System.out.println("Here are the timeslots for:"  + selDate);
		DataBase db = new DataBase();
		
        db.searchByTiming(selDate);
        		
        //print timeslots for that date

        
        //set selMovie as the input user selected
        System.out.println("Please select timing");
        int selTiming = sc.nextInt();
        
        
        //searches through BookingDatabase, compareTo returns timing
        
        db.searchByTiming(selTiming);
        
       }


	@Override
	public void SearchResults() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void SearchResults(String movie) {
		// TODO Auto-generated method stub
		
	}
}
