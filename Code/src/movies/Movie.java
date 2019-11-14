package movies;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Movie implements Serializable{
	private String movieTitle; 
	private String movieSynopsis;
	private ArrayList<String> movieCast;
	private ArrayList<String> movieDirector;
	private float movieOverallRating;
	private ArrayList<Review> reviewList;
	private MovieStatus movieStatus;
	private int totalSales;
	private AgeRating ageRating;
	
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
		if (this.movieCast.isEmpty())
			return "No cast";
		else {
			String castString = String.join(", ", this.movieCast);
			return castString;
		}
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
		if (this.movieCast.isEmpty())
			return "No Director";
		else {
			String directorString = String.join(", ", this.movieDirector);
			return directorString;
		}
	}
	
	public float getMovieOverallRating() {
			return movieOverallRating;
	}
	public void setMovieOverallRating(float movieOverallRating) {
		this.movieOverallRating = movieOverallRating;
	}
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
	public void printMovieOverallRating() {
		if (this.movieOverallRating==-1) {
			System.out.println("There are not enough ratings yet.");
		}
		else {
			System.out.printf("%.2f", this.movieOverallRating);
			System.out.println();
		}
	}
	
	public void addReview() {
		Review r = new Review();
		this.reviewList.add(r);
		updateOverallRating();
	}
	
	public void printReviewList(int numberOfReviews) {
		if (reviewList.size()==0) {
			System.out.println("There are no reviews yet.");
			return;
		}
		int i=0;
		for (Review review : reviewList) {
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

	public MovieStatus getStatus() {
		return movieStatus;
	}
	public void setStatus(MovieStatus movieStatus) {
		this.movieStatus = movieStatus;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public AgeRating getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(AgeRating ageRating) {
		this.ageRating = ageRating;
	}
	
	//comment
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
}	//comment
//comment	//comment
//comment


