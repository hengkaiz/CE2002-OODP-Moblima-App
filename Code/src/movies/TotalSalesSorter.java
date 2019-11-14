package movies;

import java.util.Comparator;

public class TotalSalesSorter implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o2.getTotalSales(), o1.getTotalSales());	//descending order
    }
}
//comment
//comment