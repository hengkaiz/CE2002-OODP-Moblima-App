package user;
import Movie.Movie;
import java.util.ArrayList;
import java.util.Scanner;
import Database.DataBase;
import Movies.MovieDatabase;
import Cinema.ShowTime;

public class SearchByMovie implements SearchFunction{
	
	public void searchbymovie() {
		//creates object movieList
		
		Movie[] movieList = MovieDatabase.getMovieList();
		
		// prints out movie list
		System.out.println(movieList);
        
        //set selMovie as the input user selected
        System.out.println("Please select movie");
        Scanner sc = new Scanner(System.in);
        String selMovie = sc.nextLine();
        
        
        //searches through BookingDatabase, compareTo returns timing
        DataBase.searchByMovie(selMovie);
        
       }

	@Override
	public void SearchResults() {
		// TODO Auto-generated method stub
		
	}
		
	

}
