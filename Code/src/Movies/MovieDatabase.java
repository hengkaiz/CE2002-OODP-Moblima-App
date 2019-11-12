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

package Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieDatabase {
    private ArrayList<Movie> movielist;

    public MovieDatabase(){
        movielist = new ArrayList<Movie>();
    }

    public void addMovie(){
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        String type = sc.nextLine();
        String status = sc.nextLine();
        String agelimit = sc.nextLine();
        int runtime = sc.nextInt();
        movielist.add(new Movie(title, type, status, agelimit, runtime));
    }


}
