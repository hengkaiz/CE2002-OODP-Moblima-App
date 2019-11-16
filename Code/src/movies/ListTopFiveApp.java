package movies;

import moblima.SaveAndLoadDB;

public class ListTopFiveApp {
	private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
	private MovieDatabase mdb;

	public ListTopFiveApp() {
		this.mdb = saveAndLoadDB.loadMovieDB();
	}
	
	public void printTopByOverallRating() {
		int i=1;
		for (Movie movie : mdb.topByOverallRating(5)) {
			System.out.print(i + ". " + movie.getMovieTitle() + ": ");
			movie.printMovieOverallRating();
			i++;
		}
	}

	public void printTopByTotalSales() {
		int i=1;
		for (Movie movie : mdb.topByTotalSales(5)) {
			System.out.println(i + ". " + movie.getMovieTitle() + ": " + movie.getTotalSales());
			i++;
		}
	}
}
