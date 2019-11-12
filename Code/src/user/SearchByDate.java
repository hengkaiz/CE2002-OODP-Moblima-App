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
        String selDate = sc.nextLine();
        
        
		Movie[] movieList;
		MovieDatabase md = new MovieDatabase();
		movieList = md.getMovieList();
		
		// prints timeslots for that date
		System.out.println(movieList);
        
        //set selMovie as the input user selected
        System.out.println("Please select movie");
        Scanner sc = new Scanner(System.in);
        String selMovie = sc.nextLine();
        
        
        //searches through BookingDatabase, compareTo returns timing
        DataBase db = new DataBase();
        db.searchByMovie(selMovie);
        
       }
}
