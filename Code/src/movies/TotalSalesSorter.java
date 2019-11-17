package movies;

import java.util.Comparator;

/**
 * a sorter that compares movies by total sales
 */
public class TotalSalesSorter implements Comparator<Movie>{
	/**
	 * compares movies by total sales
	 * @return 0 if equal; 
	 * a value less than 0 if o2 < o1; 
	 * and a value greater than 0 if o2 > o1
	 */
    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o2.getTotalSales(), o1.getTotalSales());	//descending order
    }
}