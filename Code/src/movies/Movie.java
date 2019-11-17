package movies;
import moblima.SaveAndLoadDB;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * represents a movie with all its details
 */
public class Movie implements Serializable{
	/**
	 * To identify the version of the class used in Serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * movie title
	 */
	private String movieTitle; 
	/**
	 * movie synopsis
	 */
	private String movieSynopsis;
	/**
	 * array list of cast members
	 */
	private ArrayList<String> movieCast;
	/**
	 * array list of directors
	 */
	private ArrayList<String> movieDirector;
	/**
	 * overall rating for the movie based on reviews on the system
	 */
	private float movieOverallRating;
	/**
	 * array list of review objects
	 */
	private ArrayList<Review> reviewList;
	/**
	 * status of the movie
	 */
	private MovieStatus movieStatus;
	/**
	 * total sales of the movie
	 */
	private int totalSales;
	/**
	 * age rating for the movie
	 */
	private AgeRating ageRating;
	
	/**
	 * This constructs a movie object by asking staff to key in details such as:
	 * title, synopsis, movie status, cast members, directors, total sales and age rating
	 */
	public Movie() {
		System.out.println("Creating new movie...");
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
		
		this.movieOverallRating = -1;
		this.reviewList = new ArrayList<Review>();
		
		this.movieCast = new ArrayList<String>();
		System.out.println("Add cast for the movie one by one. Key in -1 to stop adding cast members.");
		
		String castMember=sc.nextLine();
		castMember=sc.nextLine();
		while(!castMember.equals("-1")) {
			this.addMovieCast(castMember);
			castMember = sc.nextLine();
		}
		
		this.movieDirector = new ArrayList<String>();
		System.out.println("Add director for the movie one by one. Key in -1 to stop adding directors.");
		String director = sc.nextLine();
		while(!director.equals("-1")) {
			this.addMovieDirector(director);
			director = sc.nextLine();
		}
		
		System.out.println("Enter total sales: ");
		this.totalSales = sc.nextInt();
		
		System.out.println("Choose age rating: ");
		int j = 1;
		for(AgeRating ageRating : AgeRating.values()) {
			System.out.println(j + ". " +ageRating.getName());
			j++;
		}
		int ratingChoice = sc.nextInt();
		AgeRating[] ageRatingList = AgeRating.values();			//create array with all the ageRating
		for(AgeRating ageRating : ageRatingList) {				//go through array until find the one equal to user input
			if(ageRating.ordinal()==ratingChoice-1){
				this.ageRating = ageRating;
			}
		}
		
		System.out.println("Created movie: " +this.movieTitle);
		
	}
	/**
	 * This constructs a movie object with the input title, synopsis and status
	 * @param movieTitle This is the title of movie
	 * @param movieSynopsis This is the synopsis of movie
	 * @param movieStatus This is the status of the movie
	 */
    public Movie(String movieTitle, String movieSynopsis, MovieStatus movieStatus) {
		this.movieTitle = movieTitle;
		this.movieSynopsis = movieSynopsis;
		this.movieCast = new ArrayList<String>();
		this.movieDirector = new ArrayList<String>();
		this.movieOverallRating = -1;
		this.reviewList = new ArrayList<Review>();
		this.movieStatus = movieStatus;
		this.totalSales = 0;
		this.ageRating = ageRating.GENERAL;
	}
    
	/**
	 * @return current title of the movie
	 */
	public String getMovieTitle() {
		return movieTitle;
	}
	/**
	 * @param movieTitle title to set
	 */
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	/**
	 * @return current synopsis of the movie
	 */
	public String getMovieSynopsis() {
		return movieSynopsis;
	}
	/**
	 * @param movieSynopsis synopsis to set
	 */
	public void setMovieSynopsis(String movieSynopsis) {
		this.movieSynopsis = movieSynopsis;
	}

	/**
	 * takes in a String cast name and adds it onto the cast list 
	 * @param movieCast name of cast to add
	 */
	public void addMovieCast(String movieCast) {
		this.movieCast.add(movieCast);
	}
	/**
	 * @param movieCast name of cast to be removed from the list of casts
	 */
	public void removeMovieCast(String movieCast) {
		if(this.movieCast.remove(movieCast)) {
			System.out.println("Cast removed");
		}
		else {
			System.out.println("Cast does not exist");
		}
	}
	/**
	 * @return the names on the cast list separated by commas
	 */
	public String toStringMovieCast() {
		if (this.movieCast.isEmpty())
			return "No cast";
		else {
			String castString = String.join(", ", this.movieCast);
			return castString;
		}
	}

	/**
	 * @param movieDirector director name to add
	 */
	public void addMovieDirector(String movieDirector) {
		this.movieDirector.add(movieDirector);
	}
	/**
	 * @param movieDirector name of director to be removed from list of directors
	 */
	public void removeMovieDirector(String movieDirector) {
		if(this.movieDirector.remove(movieDirector)) {
			System.out.println("Director removed");
		}
		else {
			System.out.println("Director does not exist");
		}
	}
	/**
	 * @return the names on the directors list separated by commas
	 */
	public String toStringMovieDirector() {
		if (this.movieDirector.isEmpty())
			return "No Director";
		else {
			String directorString = String.join(", ", this.movieDirector);
			return directorString;
		}
	}
	
	/**
	 * @return current movie overall rating (-1 if there are less than 2 ratings)
	 */
	public float getMovieOverallRating() {
			return movieOverallRating;
	}
	/**
	 * @param movieOverallRating overall rating to set
	 */
	public void setMovieOverallRating(float movieOverallRating) {
		this.movieOverallRating = movieOverallRating;
	}
	/**
	 * this updates the overall rating by calculating the average of all the review ratings
	 * if there are less than 2 ratings, the overall rating is automatically set to 0
	 */
	public void updateOverallRating() {
		if (reviewList.size()>1) {
			float sum=0;
			for(Review review : reviewList) {
				sum+=review.getRating();
			}
			this.movieOverallRating = sum/((float)this.reviewList.size());
		}
		else
			this.movieOverallRating = -1;
	}
	/**
	 * this prints the overall rating (1dp)
	 * if there are less than 2 ratings, NA is printed
	 */
	public void printMovieOverallRating() {
		SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
		MovieDatabase mdb = saveAndLoadDB.loadMovieDB();
		int i = 0;

		for (Movie m: mdb.getMovies()){
			if(m.getMovieTitle().contentEquals(this.movieTitle)){
				i++;
				break;
			}
		}
		if (mdb.getMovies().get(i).movieOverallRating==-1) {
			System.out.println("NA, There are not enough ratings yet.");
		}
		else {
			System.out.printf("%.1f", mdb.getMovies().get(i).movieOverallRating);
			System.out.println();
		}
	}
	/**
	 * creates a new review object and adds it to the review list
	 * overall rating is updated to include the new rating from the review
	 */
	public void addReview() {
		Review r = new Review();
		this.reviewList.add(r);
		updateOverallRating();
	}

	public ArrayList<Review> getReviewList(){
		return reviewList;
	}
	/**
	 * this prints the reviews and reviewer ratings in proper format
	 * if there are no reviews yet, it will print there are no reviews yet
	 * @param numberOfReviews number of reviews to be printed
	 */
	public void printReviewList(int numberOfReviews) {
		SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
		MovieDatabase mdb = saveAndLoadDB.loadMovieDB();
		int i = 0;

		for (Movie m: mdb.getMovies()){
			if(m.getMovieTitle().contentEquals(this.movieTitle)){
				i++;
				break;
			}
		}
		if (mdb.getMovies().get(i).reviewList.size()==0) {
			System.out.println("There are no reviews yet.");
			return;
		}
		for (Review review : mdb.getMovies().get(i).getReviewList()) {
			if (review==null)
				return;
			System.out.println(review.toStringRating());
			System.out.println(review.toStringReview());
			System.out.println();
			i++;
			if (i == numberOfReviews)
				return;
		}
	}
	/**
	 * @return current movie status (eg: Now Showing)
	 */
	public MovieStatus getStatus() {
		return movieStatus;
	}
	/**
	 * @param movieStatus status to set
	 */
	public void setStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}
	/**
	 * @return current total sales for the movie
	 */
	public int getTotalSales() {
		return totalSales;
	}
	/**
	 * @param totalSales total sales value to be set
	 */
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	/**
	 * @return current age rating
	 */
	public AgeRating getAgeRating() {
		return ageRating;
	}

	/**
	 * @param ageRating age rating to set
	 */
	public void setAgeRating(AgeRating ageRating) {
		this.ageRating = ageRating;
	}
//	public static void main(String[] args) {
//		Movie m = new Movie();
//		m.addReview();
//		m.printMovieOverallRating();
//		m.addReview();
//		m.printMovieOverallRating();
//		m.addReview();
//		m.printMovieOverallRating();
//		m.printReviewList(2);
//	}
}

