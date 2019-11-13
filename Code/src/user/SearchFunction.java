package user;

import Cinema.ShowTime;
import Database.DataBase;
import Movies.MovieDatabase;

import java.util.ArrayList;

public interface SearchFunction {
	public void searchResult();

	public ArrayList<ShowTime> searchApp(MovieDatabase mb);
}
