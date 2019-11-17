package movies;

import moblima.SaveAndLoadDB;
/**
 * lists the top 5 movies (based on rating or total sales)
 */
public class ListTopFiveApp {
	/**
	 * Allows saving and loading of the actual database to and from a local copy
	 */
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	/**
	 * object reference to load the actual movie database on to
	 */
	private MovieDatabase mdb;
	
	/**
	 * loads the movie database on to mdb object reference
	 */
	public ListTopFiveApp() {
		this.mdb = saveAndLoadDB.loadMovieDB();
	}
	
	/**
	 * prints top 5 movies by overall rating
	 */
	public void printTopByOverallRating() {
		int i=1;
		for (Movie movie : mdb.topByOverallRating(5)) {
			System.out.print(i + ". " + movie.getMovieTitle() + ": ");
			movie.printMovieOverallRating();
			i++;
		}
	}

	/**
	 * prints top 5 movies by total sales
	 */
	public void printTopByTotalSales() {
		int i=1;
		for (Movie movie : mdb.topByTotalSales(5)) {
			System.out.println(i + ". " + movie.getMovieTitle() + ": " + movie.getTotalSales());
			i++;
		}
	}
}
