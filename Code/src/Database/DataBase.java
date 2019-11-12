package Database;

import Cinema.ShowTime;
import Movies.Movie;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase{
    private ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
    private ArrayList<ShowTime> copylist;

    public DataBase(){
        Movie m = new Movie("penisland", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, m, 3));
        Movie mm = new Movie("penisland2", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, mm, 3));
        Movie mmmm = new Movie("penisland3", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, mmmm, 2));
        Movie mmmm1 = new Movie("penisland1", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, mmmm1, 1));
    }

    private ArrayList<ShowTime> sortMovies(String title){
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.getMovie() == title){
                copylist.add(st);
            }
        }
        return copylist;
    }

    private ArrayList<ShowTime> sortTiming(int timing){
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.getTiming() == timing){
                copylist.add(st);
            }
        }
        return copylist;
    }

    private ArrayList<ShowTime> sortDate(int date){
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.getDate() == date){
            	
                copylist.add(st.getTiming());
            }
        }
        return copylist;
    }

    public ArrayList<ShowTime> searchByMovie(String title){
        return sortMovies(title);
    }

    public ArrayList<ShowTime> searchByTiming(int timing){
        return sortTiming(timing);
    }

    public ArrayList<ShowTime> searchByDate(int date){
        return sortDate(date);
    }
    public void addShowTime(ShowTime s) {
    	showtimelist.add(s);
    }
    public ArrayList<ShowTime> getShowTimes(){
    	return showtimelist;
    }
 
}
