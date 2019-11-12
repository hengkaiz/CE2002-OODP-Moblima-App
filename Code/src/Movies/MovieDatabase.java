package Movies;
import java.util.ArrayList;


public class MovieDatabase {
	private ArrayList<Movie> movieList;
	
	public void getMovieDetails(Movie movie){
		System.out.println("Title: "		+ movie.getMovieTitle());
		System.out.println("Synopsis: "		+ movie.getMovieSynopsis());
		System.out.println("Cast: "			+ movie.toStringMovieCast());
		System.out.println("Director: "		+ movie.toStringMovieDirector());
		System.out.println("Overall Rating: " + movie.getMovieOverallRating());
		System.out.println("Reviews: " 		+ movie.getReviewList());
	}

	
}
