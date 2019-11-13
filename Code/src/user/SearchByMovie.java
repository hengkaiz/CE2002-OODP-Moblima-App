package user;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
import Database.*;
import movies.*;
import Cinema.*;


public class SearchByMovie extends DataBase implements SearchFunction{
	private ArrayList<String> movieList = new ArrayList<String>();
	private ArrayList<ShowTime> showtimes;
	private MovieDatabase mb;
	private DataBase db;

	public void searchResult() {
		//gets an array of movie titles from movie database
		int selMovie;
		String movietitle;
		Scanner sc = new Scanner(System.in);
		movieList = mb.getMovieTitlesList();

		// prints out movie list
		System.out.println("Currently Showing:");
		for (int i=0; i<movieList.size();i++){

			System.out.printf("%d: %s", i+1, movieList.get(i));
		}

        //set selMovie as the input user selected
        System.out.println("Please select movie");
		selMovie = sc.nextInt();
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
