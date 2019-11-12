package user;
import user.SearchByDate;
import user.SearchByMovie;
import Database.DataBase;

public class MainFunction {
	public static void main(String[] args) {
		
		DataBase db = new DataBase();
		SearchByMovie sm = new SearchByMovie();
		sm.searchbymovie();
		
		
	}

}
