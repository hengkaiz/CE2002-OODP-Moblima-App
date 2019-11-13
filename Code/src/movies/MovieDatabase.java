package movies;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	
	Scanner sc = new Scanner(System.in);
	
	public MovieDatabase(){
		this.movieList = new ArrayList<Movie>();
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void addMovieToDB(){
		Movie m = new Movie();
		this.movieList.add(m);
	}

	public void removeMovieFromDB(){
		System.out.println("Which movie do you want to remove?");
		int i=1;
		for (Movie movie : movieList) {
			System.out.println(i + ". " + movie.getMovieTitle());
			i++;
		}
		int choice = sc.nextInt();
		
		movieList.remove(choice-1);
	}
	
	
	
	public void printMovieDetails(){
		System.out.println("Which movie do you want to know more about?");
		int i=1;
		for (Movie movie : movieList) {
			System.out.println(i + ". " + movie.getMovieTitle());
			i++;
		}
		int choice = sc.nextInt();
		
		Movie chosenMovie = movieList.get(choice-1);
		
		System.out.println("Title: "		+ chosenMovie.getMovieTitle());
		System.out.println("Synopsis: "		+ chosenMovie.getMovieSynopsis());
		System.out.println("Cast: "			+ chosenMovie.toStringMovieCast());
		System.out.println("Director: "		+ chosenMovie.toStringMovieDirector());
		System.out.println("Status: "		+ chosenMovie.getStatus().getName());
		System.out.println("Total Sales: "	+ chosenMovie.getTotalSales());
		System.out.println("Age Rating: "	+ chosenMovie.getAgeRating().getName());
		System.out.print("Overall Rating: " );
		chosenMovie.printMovieOverallRating();
		System.out.print("Reviews: " );
		chosenMovie.printReviewList(3);
	}
	
	public ArrayList<String> getMovieTitlesList(){
		ArrayList <String> titlesOnly = new ArrayList<String>();
		
		for (Movie movie: movieList)
			if(movie.getStatus().getName().contentEquals("Now Showing"))
				titlesOnly.add(movie.getMovieTitle());
		return titlesOnly;
	}

	public ArrayList<Movie> getMovies(){
		return movieList;
	}
	public static void main(String[] args) {
		MovieDatabase mdb = new MovieDatabase();
		mdb.addMovieToDB();
		mdb.printMovieDetails();
		System.out.println(mdb.getMovieTitlesList());
		mdb.addMovieToDB();
		mdb.printMovieDetails();
		System.out.println(mdb.getMovieTitlesList());
		mdb.removeMovieFromDB();
		mdb.printMovieDetails();
		System.out.println(mdb.getMovieTitlesList());
	}
}
