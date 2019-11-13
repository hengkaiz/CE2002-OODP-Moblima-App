package user;

import Movies.*;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
import Database.*;
import Cinema.*;
import Movies.*;


public class SearchByMovie implements SearchFunction{
	private ArrayList<String> movieList = new ArrayList<String>();
	private ArrayList<ShowTime> showtimes;

	public void searchResult() {
		//gets an array of movie titles from movie database
		int selMovie;
		String movietitle;
		Scanner sc = new Scanner(System.in);
		MovieDatabase mb = new MovieDatabase();
		movieList = mb.getMovieTitlesList();

		// prints out movie list
		for (int i=0; i<movieList.size();i++){
			System.out.printf("%d: %s", i+1, movieList.get(i));
		}

        //set selMovie as the input user selected
        System.out.println("Please select movie");
		selMovie = sc.nextInt();
        movietitle = movieList.get(selMovie-1);

        //searches through BookingDatabase, compareTo returns timing
        DataBase db = new DataBase();

        showtimes = db.searchByMovie(movietitle);
       }
}
