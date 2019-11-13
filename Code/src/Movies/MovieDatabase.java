package Movies;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	
	Scanner sc = new Scanner(System.in);
	
	public MovieDatabase() {
		movieList=new ArrayList<Movie>();
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
	
	public void getMovieDetails(Movie movie){
		System.out.println("Title: "		+ movie.getMovieTitle());
		System.out.println("Synopsis: "		+ movie.getMovieSynopsis());
		System.out.println("Cast: "			+ movie.toStringMovieCast());
		System.out.println("Director: "		+ movie.toStringMovieDirector());
		System.out.println("Overall Rating: " + movie.getMovieOverallRating());
		System.out.println("Reviews: " );
		movie.printReviewList(3);
	}
	
	public ArrayList<String> getMovieTitlesList(){
		ArrayList <String> titlesOnly = new ArrayList<String>();
		
		for (Movie movie: movieList)
			titlesOnly.add(movie.getMovieTitle());
		
		return titlesOnly;
	}
}
