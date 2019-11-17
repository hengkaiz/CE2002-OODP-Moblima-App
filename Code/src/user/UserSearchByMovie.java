package user;

import java.util.ArrayList;

import java.util.Scanner;

import moblima.SaveAndLoadDB;
import movies.*;
import cinema.*;

/**
 * search movie by title
 */
public class UserSearchByMovie{
	/**
	 * ArrayList of ShowTime
	 */
	private ArrayList<String> movieList = new ArrayList<String>();
	/**
	 * copy of ArrayList of ShowTime
	 */
	private ArrayList<ShowTime> showtimes = null;
	/**
	 * object reference to load the actual movie database on to mb
	 */
	private MovieDatabase mb;
	/**
	 * object reference to load the actual showtime database on to db
	 */
	private ShowTimeDatabase db;
	/**
	 * search movie by title and add found movies to ShowTimes
	 */
	public void searchResult() throws NullPointerException{
		//gets an array of movie titles from movie database
		int selMovie;
		String movietitle = null;
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
        showtimes = db.searchByMovie(movietitle);
       }
	/**
	 * search movie by title
	 * @param mb is the object reference to load the actual movie database on to mb
	 * @param cineplexNum is the cinplex the user chose
	 * @return the ArrayList of showtimes found
	 */
	public ArrayList<ShowTime> searchApp(MovieDatabase mb, int cineplexNum) {
		SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
		this.db = saveAndLoadDB.loadShowTimeDB(cineplexNum);
		System.out.println("\n---Search By Movie---");

		this.mb = mb;
		searchResult(); //get show time for the movies

		return showtimes;
	}
	/**
	 * search movie by title for reviews
	 * @param mb is the object reference to load the actual movie database on to mb
	 * @return Movie object found
	 */
	public Movie returnMovie(MovieDatabase mb) {
		//gets an array of movie titles from movie database
		int selMovie = 0;
		ArrayList<Movie> movieListLong = new ArrayList<Movie>();
		Scanner sc = new Scanner(System.in);
		movieList = mb.getMovieTitlesList();

		// prints out movie list
		System.out.println("\nCurrently Showing:");
		for (int i=0; i<movieList.size();i++){
			System.out.printf("%d: %s\n", i+1, movieList.get(i));
		}
		System.out.println("-1 to return");
        //set selMovie as the input user selected
        System.out.print("Please select movie: ");
		try {
			selMovie = sc.nextInt();
			if (selMovie == -1) {
				return null;
			}
			else if(selMovie < 1 || selMovie > movieList.size()) throw new Exception("too big");
			movieListLong = mb.getMovies();

		} catch (Exception e) {
			System.out.println("Invalid Selection. Try Again.");
			return null;
		}

        
        //gets movie info in Movie format
		return movieListLong.get(selMovie-1);
	}
}
