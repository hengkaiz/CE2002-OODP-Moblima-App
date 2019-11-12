package Movies;

public class Movie {
	enum Status{
		NOW_SHOWING, COMMING_SOON, PREVIEW, ENDING_SOON;
	}
	private String movieTitle; 
	private String movieSynopsis;
	private String movieCast;
	private String movieDirector;
	private float movieOverallRating;
	private Review[] reviewList;
	private Status movieStatus;
	
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
	public String getMovieCast() {
		return movieCast;
	}
	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public float getMovieOverallRating() {
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

