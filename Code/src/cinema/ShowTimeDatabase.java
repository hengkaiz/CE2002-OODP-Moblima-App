package cinema;

import cinema.MovieFormat;
import cinema.ShowTime;
import movies.*;

import java.util.ArrayList;

public class ShowTimeDatabase extends MovieDatabase{
    private ArrayList<ShowTime> showtimelist = new ArrayList<ShowTime>();
    private ArrayList<ShowTime> copylist;

    public ShowTimeDatabase(){
        showtimelist.add(new ShowTime(1200, super.getMovies().get(0), 1, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(0), 1, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1800, super.getMovies().get(0), 1, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1200, super.getMovies().get(1), 1, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1800, super.getMovies().get(1), 1, 4, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(1), 1, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(2), 1, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1400, super.getMovies().get(2), 1, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(2), 1, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1100, super.getMovies().get(3), 1, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1400, super.getMovies().get(3), 1, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(3), 1, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2400, super.getMovies().get(4), 1, 0, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2400, super.getMovies().get(5), 1, 0, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(6), 1, 3, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1600, super.getMovies().get(6), 1, 7, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(2100, super.getMovies().get(6), 1, 8, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(7), 1, 9, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2300, super.getMovies().get(7), 1, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1200, super.getMovies().get(0), 2, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(0), 2, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1800, super.getMovies().get(0), 2, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(1), 2, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1800, super.getMovies().get(1), 2, 4, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(1), 2, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(2), 2, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1400, super.getMovies().get(2), 2, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(2), 2, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1100, super.getMovies().get(3), 2, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1400, super.getMovies().get(3), 2, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(3), 2, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2400, super.getMovies().get(8), 1, 0, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2400, super.getMovies().get(9), 1, 0, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(6), 2, 3, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1600, super.getMovies().get(6), 2, 7, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(2200, super.getMovies().get(6), 2, 8, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(7), 2, 9, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2300, super.getMovies().get(7), 2, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(0), 3, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(0), 3, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1800, super.getMovies().get(0), 3, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1600, super.getMovies().get(1), 3, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1800, super.getMovies().get(1), 3, 4, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(1), 3, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1000, super.getMovies().get(2), 3, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(2), 3, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(2), 3, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1200, super.getMovies().get(3), 3, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(3), 3, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(3), 3, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1100, super.getMovies().get(6), 3, 3, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(6), 3, 7, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(2100, super.getMovies().get(6), 3, 8, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1400, super.getMovies().get(7), 3, 9, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2200, super.getMovies().get(7), 3, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1200, super.getMovies().get(0), 4, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1400, super.getMovies().get(0), 4, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(0), 4, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1100, super.getMovies().get(1), 4, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(1), 4, 4, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(1), 4, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1200, super.getMovies().get(2), 4, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1600, super.getMovies().get(2), 4, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(2), 4, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1000, super.getMovies().get(3), 4, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(3), 4, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(3), 4, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(6), 4, 3, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(6), 4, 7, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(2300, super.getMovies().get(6), 4, 8, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1100, super.getMovies().get(7), 4, 9, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2200, super.getMovies().get(7), 4, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(0), 5, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(0), 5, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1900, super.getMovies().get(0), 5, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1100, super.getMovies().get(1), 5, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1600, super.getMovies().get(1), 5, 4, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1700, super.getMovies().get(1), 5, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1400, super.getMovies().get(2), 5, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1600, super.getMovies().get(2), 5, 5, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1800, super.getMovies().get(2), 5, 3, MovieFormat.THREE_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(3), 5, 1, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1200, super.getMovies().get(3), 5, 6, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1600, super.getMovies().get(3), 5, 2, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(1300, super.getMovies().get(6), 5, 3, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1500, super.getMovies().get(6), 5, 7, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(2200, super.getMovies().get(6), 5, 8, MovieFormat.BLOCKBUSTER));
        showtimelist.add(new ShowTime(1100, super.getMovies().get(7), 5, 9, MovieFormat.TWO_DIMENSION));
        showtimelist.add(new ShowTime(2200, super.getMovies().get(7), 5, 2, MovieFormat.TWO_DIMENSION));

    }

    private ArrayList<ShowTime> sortMovies(String title){ //return showtimes for chosen movie
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.getMovie().contentEquals(title)){
                copylist.add(st);
            }
        }
        return copylist;
    }

    private ArrayList<ShowTime> sortDate(String date){ //return showtimes for chosen dates
        copylist = new ArrayList<ShowTime>();
        for (ShowTime st: showtimelist){
            if (st.toStringGetDate().contentEquals(date)){
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
