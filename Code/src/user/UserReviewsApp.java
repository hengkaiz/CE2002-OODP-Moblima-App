package user;

import moblima.SaveAndLoadDB;
import movies.Movie;
import movies.MovieDatabase;
//import user.UserSearchByMovie;
/**
 * add review to movies
 */
public class UserReviewsApp {
    /**
     * Allows saving and loading of the actual database to and from a local copy
     */
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
    /**
     * object reference to load the actual movie database on to mdb
     */
    private MovieDatabase mdb;
    /**
     * the selected Movie object
     */
    private Movie movieToReview;

    /**
     * constructs a UserReviewsApp object
     */
    public UserReviewsApp() {
    	mdb = saveAndLoadDB.loadMovieDB();
    	
    }
    /**
     * get the Movie object of the movie to review
     * @return the selected Movie object
     */
    public Movie getMovie() {
    	UserSearchByMovie reviewMovie = new UserSearchByMovie();
        movieToReview = reviewMovie.returnMovie(this.mdb);
        return movieToReview;
    }
    /**
     * add new review to the selected movie
     * @param movieToReview is the selected movie
     */
    public void addReview(Movie movieToReview) {
        if (movieToReview == null)return;
    	movieToReview.addReview();
    	saveAndLoadDB.saveMovieDB(mdb);
    }
    

}
