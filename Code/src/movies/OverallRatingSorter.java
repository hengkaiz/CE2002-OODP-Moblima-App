package movies;

import java.util.Comparator;

/**
 * a sorter that compares movies by overall rating
 */
public class OverallRatingSorter implements Comparator<Movie>{
	
	/**
	 * compares movies by overall rating
	 */
    @Override
    public int compare(Movie o1, Movie o2) {
        return Float.compare(o2.getMovieOverallRating(), o1.getMovieOverallRating());	//descending order
    }
}