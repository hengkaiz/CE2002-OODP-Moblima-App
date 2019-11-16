package user;
import moblima.MenuTemplate;
import movies.Movie;

import java.util.Scanner;

public class UserReviewsMenu extends MenuTemplate {
	private MenuTemplate nextMenu;

    public UserReviewsMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }
	public MenuTemplate run(){
		
		UserSearchByMovie reviewMovie = new UserSearchByMovie();
		Movie addMovieReview = new Movie();
		
	    addMovieReview = reviewMovie.returnMovie(mdb);
	    addMovieReview.addReview();
	    nextMenu = this;
	
	
	    return nextMenu.run();
		}
}

