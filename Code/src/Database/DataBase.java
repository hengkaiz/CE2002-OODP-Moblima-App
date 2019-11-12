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

    public ArrayList<ShowTime> searchByMovie(String title){
        return sortMovies(title);
    }

}
