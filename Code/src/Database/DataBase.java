package Database;

import Cinema.MovieFormat;
import Cinema.ShowTime;
import movies.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase extends MovieDatabase{
    private ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
    private ArrayList<ShowTime> copylist;

    public DataBase(){
        ShowTime st1 = new ShowTime(1200, super.getMovies().get(0), 1, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st2 = new ShowTime(1500, super.getMovies().get(0), 1, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st3 = new ShowTime(1800, super.getMovies().get(0), 1, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st4 = new ShowTime(1200, super.getMovies().get(1), 1, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st5 = new ShowTime(1800, super.getMovies().get(1), 1, 4, MovieFormat.TWO_DIMENSION);
        ShowTime st6 = new ShowTime(1900, super.getMovies().get(1), 1, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st7 = new ShowTime(1300, super.getMovies().get(2), 1, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st8 = new ShowTime(1400, super.getMovies().get(2), 1, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st9 = new ShowTime(1900, super.getMovies().get(2), 1, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st10 = new ShowTime(1100, super.getMovies().get(3), 1, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st11 = new ShowTime(1400, super.getMovies().get(3), 1, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st12 = new ShowTime(1700, super.getMovies().get(3), 1, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st13 = new ShowTime(2400, super.getMovies().get(4), 100, 0, MovieFormat.TWO_DIMENSION);
        ShowTime st14 = new ShowTime(2400, super.getMovies().get(5), 100, 0, MovieFormat.TWO_DIMENSION);
        ShowTime st15 = new ShowTime(1300, super.getMovies().get(6), 1, 3, MovieFormat.BLOCKBUSTER);
        ShowTime st16 = new ShowTime(1600, super.getMovies().get(6), 1, 7, MovieFormat.BLOCKBUSTER);
        ShowTime st17 = new ShowTime(2100, super.getMovies().get(6), 1, 8, MovieFormat.BLOCKBUSTER);
        ShowTime st18 = new ShowTime(1300, super.getMovies().get(7), 1, 9, MovieFormat.TWO_DIMENSION);
        ShowTime st19 = new ShowTime(2300, super.getMovies().get(7), 1, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st20 = new ShowTime(1200, super.getMovies().get(0), 2, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st21 = new ShowTime(1500, super.getMovies().get(0), 2, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st22 = new ShowTime(1800, super.getMovies().get(0), 2, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st23 = new ShowTime(1500, super.getMovies().get(1), 2, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st24 = new ShowTime(1800, super.getMovies().get(1), 2, 4, MovieFormat.TWO_DIMENSION);
        ShowTime st25 = new ShowTime(1900, super.getMovies().get(1), 2, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st26 = new ShowTime(1300, super.getMovies().get(2), 2, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st27 = new ShowTime(1400, super.getMovies().get(2), 2, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st28 = new ShowTime(1900, super.getMovies().get(2), 2, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st29 = new ShowTime(1100, super.getMovies().get(3), 2, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st30 = new ShowTime(1400, super.getMovies().get(3), 2, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st31 = new ShowTime(1700, super.getMovies().get(3), 2, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st32 = new ShowTime(2400, super.getMovies().get(8), 100, 0, MovieFormat.TWO_DIMENSION);
        ShowTime st33 = new ShowTime(2400, super.getMovies().get(9), 100, 0, MovieFormat.TWO_DIMENSION);
        ShowTime st34 = new ShowTime(1300, super.getMovies().get(6), 2, 3, MovieFormat.BLOCKBUSTER);
        ShowTime st35 = new ShowTime(1600, super.getMovies().get(6), 2, 7, MovieFormat.BLOCKBUSTER);
        ShowTime st36 = new ShowTime(2200, super.getMovies().get(6), 2, 8, MovieFormat.BLOCKBUSTER);
        ShowTime st37 = new ShowTime(1300, super.getMovies().get(7), 2, 9, MovieFormat.TWO_DIMENSION);
        ShowTime st38 = new ShowTime(2300, super.getMovies().get(7), 2, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st39 = new ShowTime(1500, super.getMovies().get(0), 3, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st40 = new ShowTime(1500, super.getMovies().get(0), 3, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st41 = new ShowTime(1800, super.getMovies().get(0), 3, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st42 = new ShowTime(1600, super.getMovies().get(1), 3, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st43 = new ShowTime(1800, super.getMovies().get(1), 3, 4, MovieFormat.TWO_DIMENSION);
        ShowTime st44 = new ShowTime(1700, super.getMovies().get(1), 3, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st45 = new ShowTime(1000, super.getMovies().get(2), 3, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st46 = new ShowTime(1300, super.getMovies().get(2), 3, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st47 = new ShowTime(1900, super.getMovies().get(2), 3, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st48 = new ShowTime(1200, super.getMovies().get(3), 3, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st49 = new ShowTime(1300, super.getMovies().get(3), 3, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st50 = new ShowTime(1700, super.getMovies().get(3), 3, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st51 = new ShowTime(1100, super.getMovies().get(6), 3, 3, MovieFormat.BLOCKBUSTER);
        ShowTime st52 = new ShowTime(1500, super.getMovies().get(6), 3, 7, MovieFormat.BLOCKBUSTER);
        ShowTime st53 = new ShowTime(2100, super.getMovies().get(6), 3, 8, MovieFormat.BLOCKBUSTER);
        ShowTime st54 = new ShowTime(1400, super.getMovies().get(7), 3, 9, MovieFormat.TWO_DIMENSION);
        ShowTime st55 = new ShowTime(2200, super.getMovies().get(7), 3, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st56 = new ShowTime(1200, super.getMovies().get(0), 4, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st57 = new ShowTime(1400, super.getMovies().get(0), 4, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st58 = new ShowTime(1900, super.getMovies().get(0), 4, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st59 = new ShowTime(1100, super.getMovies().get(1), 4, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st60 = new ShowTime(1700, super.getMovies().get(1), 4, 4, MovieFormat.TWO_DIMENSION);
        ShowTime st61 = new ShowTime(1900, super.getMovies().get(1), 4, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st62 = new ShowTime(1200, super.getMovies().get(2), 4, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st63 = new ShowTime(1600, super.getMovies().get(2), 4, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st64 = new ShowTime(1900, super.getMovies().get(2), 4, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st65 = new ShowTime(1000, super.getMovies().get(3), 4, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st66 = new ShowTime(1300, super.getMovies().get(3), 4, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st67 = new ShowTime(1700, super.getMovies().get(3), 4, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st68 = new ShowTime(1300, super.getMovies().get(6), 4, 3, MovieFormat.BLOCKBUSTER);
        ShowTime st69 = new ShowTime(1500, super.getMovies().get(6), 4, 7, MovieFormat.BLOCKBUSTER);
        ShowTime st70 = new ShowTime(2300, super.getMovies().get(6), 4, 8, MovieFormat.BLOCKBUSTER);
        ShowTime st71 = new ShowTime(1100, super.getMovies().get(7), 4, 9, MovieFormat.TWO_DIMENSION);
        ShowTime st72 = new ShowTime(2200, super.getMovies().get(7), 4, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st73 = new ShowTime(1300, super.getMovies().get(0), 5, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st74 = new ShowTime(1700, super.getMovies().get(0), 5, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st75 = new ShowTime(1900, super.getMovies().get(0), 5, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st76 = new ShowTime(1100, super.getMovies().get(1), 5, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st77 = new ShowTime(1600, super.getMovies().get(1), 5, 4, MovieFormat.TWO_DIMENSION);
        ShowTime st78 = new ShowTime(1700, super.getMovies().get(1), 5, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st79 = new ShowTime(1400, super.getMovies().get(2), 5, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st80 = new ShowTime(1600, super.getMovies().get(2), 5, 5, MovieFormat.TWO_DIMENSION);
        ShowTime st81 = new ShowTime(1800, super.getMovies().get(2), 5, 3, MovieFormat.THREE_DIMENSION);
        ShowTime st82 = new ShowTime(1300, super.getMovies().get(3), 5, 1, MovieFormat.TWO_DIMENSION);
        ShowTime st83 = new ShowTime(1200, super.getMovies().get(3), 5, 6, MovieFormat.TWO_DIMENSION);
        ShowTime st84 = new ShowTime(1600, super.getMovies().get(3), 5, 2, MovieFormat.TWO_DIMENSION);
        ShowTime st85 = new ShowTime(1300, super.getMovies().get(6), 5, 3, MovieFormat.BLOCKBUSTER);
        ShowTime st86 = new ShowTime(1500, super.getMovies().get(6), 5, 7, MovieFormat.BLOCKBUSTER);
        ShowTime st87 = new ShowTime(2200, super.getMovies().get(6), 5, 8, MovieFormat.BLOCKBUSTER);
        ShowTime st88 = new ShowTime(1100, super.getMovies().get(7), 5, 9, MovieFormat.TWO_DIMENSION);
        ShowTime st89 = new ShowTime(2200, super.getMovies().get(7), 5, 2, MovieFormat.TWO_DIMENSION);

    }

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
            if (st.toStringGetDate() == date){
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
    
    public void addSTToDB(ShowTime st) {
    	showtimelist.add(st);
    }
    public void removeSTToDB(ShowTime st) {
    	if(showtimelist.remove(st)) {
    		st = null;			
    		System.out.println("ShowTime removed");
		}
		else {
			System.out.println("ShowTime does not exist");
		}
    }
    /*public void updateDB(ShowTime st) {
    	
    }*/
}
