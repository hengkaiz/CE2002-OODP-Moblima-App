package user;

import moblima.SaveAndLoadDB;
import movies.Movie;
import movies.MovieDatabase;
//import user.UserSearchByMovie;

public class UserReviewsApp {
	
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
    private MovieDatabase mdb;
    private Movie movieToReview;


	    
    public UserReviewsApp() {
    	mdb = saveAndLoadDB.loadMovieDB();
    	
    }
    
    public Movie getMovie() {
    	UserSearchByMovie reviewMovie = new UserSearchByMovie();
        movieToReview = reviewMovie.returnMovie(this.mdb);
        return movieToReview;
    }
    
    public void addReview(Movie movieToReview) {
    	movieToReview.addReview();
    	saveAndLoadDB.saveMovieDB(mdb);
    }
    

}
