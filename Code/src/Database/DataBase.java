package Database;

import Cinema.ShowTime;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase{
    private ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
    private ArrayList<ShowTime> copylist;

    public DataBase(){
        Movie m = new Movie("penisland", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, m, 0, 3));
        Movie mm = new Movie("penisland2", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, mm, 1, 3));
        Movie mmmm = new Movie("penisland3", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, mmmm, 0,2));
        Movie mmmm1 = new Movie("penisland1", "penis", "in my ass", "R21", 122);
        showtimelist.add(new ShowTime(1330, mmmm1, 2,1));
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

    private ArrayList<ShowTime> sortDate(int noOfDaysFromCurrent){
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.getDate().compareTo()){
                copylist.add(st);
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

}
