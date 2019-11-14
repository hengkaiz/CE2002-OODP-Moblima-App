package user;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
import Database.*;
import movies.*;
import Cinema.*;


public class SearchByMovie extends ShowTimeDatabase implements SearchFunction{
	private ArrayList<String> movieList = new ArrayList<String>();
	private ArrayList<ShowTime> showtimes = null;
	private MovieDatabase mb;
	private ShowTimeDatabase db;

	public void searchResult() {
		//gets an array of movie titles from movie database
		int selMovie;
		String movietitle;
		Scanner sc = new Scanner(System.in);
		movieList = mb.getMovieTitlesList();

		// prints out movie list
		System.out.println("Currently Showing:");
		for (int i=0; i<movieList.size();i++){
			System.out.printf("%d: %s\n", i+1, movieList.get(i));
		}
		System.out.println("-1 to return");
        //set selMovie as the input user selected
        System.out.print("Please select movie: ");
		selMovie = sc.nextInt();
		if (selMovie == -1) return;
        movietitle = movieList.get(selMovie-1);

        //searches through BookingDatabase, compareTo returns timing
        showtimes = super.searchByMovie(movietitle);
       }

	public ArrayList<ShowTime> searchApp(MovieDatabase mb) {
		System.out.println("---Search By Movie---");
		this.mb = mb;
		searchResult(); //get show time for the movies

		return showtimes;
	}
}
