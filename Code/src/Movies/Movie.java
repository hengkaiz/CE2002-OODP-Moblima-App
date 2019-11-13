package Movies;

import java.util.Scanner;
import java.util.ArrayList;

public class Movie {
	private String movieTitle; 
	private String movieSynopsis;
	private ArrayList<String> movieCast;
	private ArrayList<String> movieDirector;
	private float movieOverallRating;
	private ArrayList<Review> reviewList;
	private MovieStatus movieStatus;
	
	public Movie() {
		System.out.println("Enter movie title: ");
		Scanner sc = new Scanner(System.in);
		this.movieTitle = sc.nextLine();
		
		System.out.println("Enter movie synopsis: ");
		this.movieSynopsis = sc.nextLine();
		
		System.out.println("Choose movie status: ");
		int i = 1;
		for(MovieStatus status : MovieStatus.values()) {
			System.out.println(i + ". " + status.getName());
			i++;
		}
		int statusChoice = sc.nextInt();
		MovieStatus[] statusList = MovieStatus.values();			//create array with all the MovieStatus
		for(MovieStatus status : statusList) {				//go through array until find the one equal to user input
			if(status.ordinal()==statusChoice-1){
				this.movieStatus = status;
			}
		}
		
		this.movieCast = new ArrayList<String>();
		System.out.println("Add cast for the movie one by one. Key in END to stop adding cast members.");
		String castMember = sc.nextLine();
		while(castMember!="END") {
			this.addMovieCast(castMember);
			castMember = sc.nextLine();
		}
		
		this.movieDirector = new ArrayList<String>();
		System.out.println("Add director for the movie one by one. Key in END to stop adding directors.");
		String director = sc.nextLine();
		while(director!="END") {
			this.addMovieDirector(director);
			director = sc.nextLine();
		}
	}
	
    public Movie(String movieTitle, String movieSynopsis, MovieStatus movieStatus) {
		this.movieTitle = movieTitle;
		this.movieSynopsis = movieSynopsis;
		this.movieCast = null;
		this.movieDirector = null;
		this.movieOverallRating = -1;
		this.reviewList = null;
		this.movieStatus = movieStatus;
	}
    
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	public String getMovieSynopsis() {
		return movieSynopsis;
	}
	public void setMovieSynopsis(String movieSynopsis) {
		this.movieSynopsis = movieSynopsis;
	}

	public void addMovieCast(String movieCast) {
		this.movieCast.add(movieCast);
	}
	public void removeMovieCast(String movieCast) {
		if(this.movieCast.remove(movieCast)) {
			System.out.println("Cast removed");
		}
		else {
			System.out.println("Cast does not exist");
		}
	}
	public String toStringMovieCast() {
		String castString = String.join(", ", this.movieCast);
		return castString;
	}

	public void addMovieDirector(String movieDirector) {
		this.movieDirector.add(movieDirector);
	}
	public void removeMovieDirector(String movieDirector) {
		if(this.movieDirector.remove(movieDirector)) {
			System.out.println("Director removed");
		}
		else {
			System.out.println("Director does not exist");
		}
	}
	public String toStringMovieDirector() {
		String directorString = String.join(", ", this.movieDirector);
		return directorString;
	}
	
	public float getMovieOverallRating() {
		if (this.movieOverallRating==-1) {
			System.out.println("There are no reviews for this movie yet.");
			return -1;
		}
		else 
			return movieOverallRating;
	}
	public void setMovieOverallRating(float movieOverallRating) {
		this.movieOverallRating = movieOverallRating;
	}
	
	public void addReview() {
		Review r = new Review();
		this.reviewList.add(r);
	}
	
	public void printReviewList(int numberOfReviews) {
		int i=0;
		for (Review review : reviewList) {
			System.out.println(review.toStringRating());
			System.out.println(review.toStringReview());
			i++;
			if (i == numberOfReviews)
				break;
		}
	}

	public MovieStatus getStatus() {
		return movieStatus;
	}
	public void setStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}
}

