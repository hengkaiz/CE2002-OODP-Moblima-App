package Database;

import Cinema.ShowTime;
import Movies. *;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase{
    private ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
    private ArrayList<ShowTime> copylist;

    public DataBase(){ }

    private ArrayList<ShowTime> sortMovies(String title){ //return showtimes for chosen movie
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.getMovie() == title){
                copylist.add(st);
            }
        }
        return copylist;
    }

    private ArrayList<ShowTime> sortDate(String date){ //return showtimes for chosen dates
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.getDate() == date){
                copylist.add(st);
            }
        }
        return copylist;
    }

    public ArrayList<ShowTime> searchByMovie(String title){ //search movie by title
        return sortMovies(title);
    }

    public ArrayList<ShowTime> searchByDate(String date){//search movie by date in format dd/MM
        return sortDate(date);
    }

    public ArrayList<ShowTime> getShowTimes(){
    	return showtimelist;
    }
    
    public void addST(ShowTime st) {
    	showtimelist.add(st);
    }
    public void removeST(ShowTime st) {
    	if(showtimelist.remove(st)) {
    		System.out.println("removed");
		}
		else {
			System.out.println("Admin account does not exist");
		}
    }
    public void updateDB(ShowTime st) {
    	
    }
}
