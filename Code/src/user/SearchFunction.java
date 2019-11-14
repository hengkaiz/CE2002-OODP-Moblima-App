package user;

import cinema.ShowTime;
import movies.MovieDatabase;

import java.util.ArrayList;

public interface SearchFunction {
	public void searchResult();

	public ArrayList<ShowTime> searchApp(MovieDatabase mb);
}
