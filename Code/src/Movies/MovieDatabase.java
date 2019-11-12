package Movies;

public class MovieDatabase {
	private Movie[] movieList;
	
	public void getMovieDetails(Movie movie){
		System.out.println("Title: "		+ movie.getMovieTitle());
		System.out.println("Synopsis: "		+ movie.getMovieSynopsis());
		System.out.println("Cast: "			+ movie.getMovieCast());
		System.out.println("Director: "		+ movie.getMovieDirector());
		System.out.println("Overall Rating: " + movie.getMovieOverallRating());
		System.out.println("Reviews: " 		+ movie.getReviewList());
	}

	public Movie[] getMovieList() {
		return movieList;
	}

	public void setMovieList(Movie[] movieList) {
		this.movieList = movieList;
	}
	
}
