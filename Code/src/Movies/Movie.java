package Movies;

import java.util.Scanner;
import java.util.ArrayList;

enum Status {
    COMING_SOON("Coming Soon"),
    PREVIEW("Preview"),
    NOW_SHOWING("Now Showing"),
    END_OF_SHOWING("End of Showing");

    private String name;

	Status(String name) {
        this.name = name;
    }
	
    public String getName() {
		return name;
	}
    
}

public class Movie {
	private String movieTitle; 
	private String movieSynopsis;
	private ArrayList<String> movieCast;
	private ArrayList<String> movieDirector;
	private float movieOverallRating;
	private Review[] reviewList;
	private Status movieStatus;
	
    public Movie(String movieTitle, String movieSynopsis, Status movieStatus) {
		this.movieTitle = movieTitle;
		this.movieSynopsis = movieSynopsis;
		this.movieOverallRating = -1;
		this.reviewList = null;
		this.movieStatus = movieStatus;
	}

	public Movie createMovie() {
		String movieTitle;
		String movieSynopsis;
		Status movieStatus=null;
		
		System.out.println("Enter movie title: ");
		Scanner sc = new Scanner(System.in);
		movieTitle = sc.nextLine();
		
		System.out.println("Enter movie synopsis: ");
		movieSynopsis = sc.nextLine();
		
		System.out.println("Choose movie status: ");
		//System.out.println("1. Now Showing");
		//System.out.println("2. Coming Soon");
		//System.out.println("3. Preview");
		//System.out.println("4. End of Showing");
		
		int i = 1;
		for(Status status : Status.values()) {
			System.out.println(i + ". " + status.getName());
			i++;
		}
		int statusChoice = sc.nextInt();
		Status[] statusList = Status.values();			//create array with all the Status
		for(Status status : statusList) {				//go through array until find the one equal to user input
			if(status.ordinal()==statusChoice-1){
				movieStatus = status;
			}
		}
		
		Movie m= new Movie(movieTitle, movieSynopsis, movieStatus);
		
		m.movieCast = new ArrayList<String>();
		
		System.out.println("Add cast for the movie one by one. Enter END to stop adding cast members.");
		String castMember = sc.nextLine();
		while(castMember!="END") {
			m.addMovieCast(castMember);
			castMember = sc.nextLine();
		}
		
		m.movieDirector = new ArrayList<String>();
		String director = sc.nextLine();
		while(director!="END") {
			m.addMovieDirector(director);
			director = sc.nextLine();
		}
		
		return m;
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

	public void addMovieDirector(String movieDirector) {
		this.movieDirector.add(movieDirector);
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
	public Review[] getReviewList() {
		return reviewList;
	}
	public void setReviewList(Review[] reviewList) {
		this.reviewList = reviewList;
	}
	public Status getStatus() {
		return movieStatus;
	}
	public void setStatus(Status movieStatus) {
		this.movieStatus = movieStatus;
	}
}

