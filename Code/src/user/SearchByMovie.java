package user;
import Movie.Movie;
import java.util.ArrayList;

public class SearchByMovie implements SearchFunctions{
	private Movie movie;
	private <ArrayLists> movieList;
	
	public void SearchResults(String movie) {
		//creates object movieList
		List<Movie> movieList = new ArrayList<>();
		
		// prints out movie list
        for(int i = 0; i < movieList.size(); i++) {
            System.out.println(movieList.get(i).getMovie());
		}  
		
				
		}
		
	

}
