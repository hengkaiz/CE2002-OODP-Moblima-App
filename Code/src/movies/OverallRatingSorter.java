package movies;

import java.util.Comparator;

public class OverallRatingSorter implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2) {
        return Float.compare(o1.getMovieOverallRating(), o2.getMovieOverallRating());
    }
}