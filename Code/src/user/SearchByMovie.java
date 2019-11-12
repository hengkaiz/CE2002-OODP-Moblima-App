package user;
import Movie.Movie;
import java.util.ArrayList;
import java.util.Scanner;
import Database;

public class SearchByMovie implements SearchFunctions{
	private Movie movie;
	private <ArrayLists> movieList;
	
	public void SearchResults(String movie) {
		//creates object movieList
		ArrayList<Database> movieList = new ArrayList<>();
		
		// prints out movie list
        for(int i = 0; i < movieList.size(); i++) {
            System.out.println(i+1, ".", movieList.get(i).getMovie());
		} 
        
        System.out.println("Please select movie based on index");
        Scanner sc = new Scanner(System.in);
        int sel = sc.nextInt();
        
        //set movieSelected as the input user selected
        String movieSelected =  Database.get(sel-1).getMovie();
        
        //searches through BookingDatabase, compareTo returns timing
        Database.searchByMovie(movieSelected);
        
       }
		
	

}
