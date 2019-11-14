package movies;

import java.util.Comparator;

public class TotalSalesSorter implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o1.getTotalSales(), o2.getTotalSales());
    }
}