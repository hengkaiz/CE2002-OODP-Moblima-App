package cinema;

import java.io.Serializable;
import cinema.MovieFormat;
import cinema.ShowTime;
import movies.*;

import java.util.ArrayList;
/**
 *represents the show time database 
 *
 */
public class ShowTimeDatabase extends MovieDatabase implements Serializable{
	/**
	 * To identify the version of the class used in Serialization
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Instantiation of the showtimeList object
	 */
	private ArrayList<ShowTime> showtimeList = new ArrayList<ShowTime>();
	/**
	 * a copy list of the showtime list in list form
	 */
    private ArrayList<ShowTime> copyList;
    /**
     * a integer variable for cinema number
     */
    private int forCinemaNumber;
    /**
     * this constructs a ShowTimeDatabase object for the ShowTimeDatabase class
     */
    public ShowTimeDatabase(){
//        showtimeList.add(new ShowTime(1200, super.getMovies().get(0), 1, 2, 6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(0), 1, 3, 5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1800, super.getMovies().get(0), 1, 1, 3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1200, super.getMovies().get(1), 1, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1800, super.getMovies().get(1), 1, 1,4, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(1), 1, 2,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(2), 1, 2,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1400, super.getMovies().get(2), 1, 1,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(2), 1, 1,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1100, super.getMovies().get(3), 1, 2,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1400, super.getMovies().get(3), 1, 3,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(3), 1, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2400, super.getMovies().get(4), 1, 3,0, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2400, super.getMovies().get(5), 1, 1,0, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(6), 1, 1,3, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1600, super.getMovies().get(6), 1, 2,7, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(2100, super.getMovies().get(6), 1, 1,8, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(7), 1, 3,9, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2300, super.getMovies().get(7), 1, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1200, super.getMovies().get(0), 2, 2,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(0), 2, 1,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1800, super.getMovies().get(0), 2, 3,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(1), 2, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1800, super.getMovies().get(1), 2, 1,4, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(1), 2, 2,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(2), 2, 3,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1400, super.getMovies().get(2), 2, 1,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(2), 2, 2,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1100, super.getMovies().get(3), 2, 3,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1400, super.getMovies().get(3), 2, 1,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(3), 2, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2400, super.getMovies().get(8), 1, 2,0, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2400, super.getMovies().get(9), 1, 3,0, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(6), 2, 1,3, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1600, super.getMovies().get(6), 2, 2,7, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(2200, super.getMovies().get(6), 2, 1,8, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(7), 2, 3,9, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2300, super.getMovies().get(7), 2, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(0), 3, 1,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(0), 3, 2,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1800, super.getMovies().get(0), 3, 3,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1600, super.getMovies().get(1), 3, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1800, super.getMovies().get(1), 3, 1,4, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(1), 3, 2,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1000, super.getMovies().get(2), 3, 1,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(2), 3, 1,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(2), 3, 2,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1200, super.getMovies().get(3), 3, 1,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(3), 3, 2,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(3), 3, 3, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1100, super.getMovies().get(6), 3, 1,3, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(6), 3, 2,7, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(2100, super.getMovies().get(6), 3, 1,8, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1400, super.getMovies().get(7), 3, 2,9, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2200, super.getMovies().get(7), 3, 3, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1200, super.getMovies().get(0), 4, 1,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1400, super.getMovies().get(0), 4, 2,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(0), 4, 2,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1100, super.getMovies().get(1), 4, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(1), 4, 3,4, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(1), 4, 3,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1200, super.getMovies().get(2), 4, 3,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1600, super.getMovies().get(2), 4, 2,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(2), 4, 2,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1000, super.getMovies().get(3), 4, 2,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(3), 4, 1,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(3), 4, 3, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(6), 4, 1,3, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(6), 4, 3,7, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(2300, super.getMovies().get(6), 4, 2,8, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1100, super.getMovies().get(7), 4, 1,9, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2200, super.getMovies().get(7), 4, 3, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(0), 5, 3,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(0), 5, 3,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1900, super.getMovies().get(0), 5, 2,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1100, super.getMovies().get(1), 5, 1, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1600, super.getMovies().get(1), 5, 2,4, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1700, super.getMovies().get(1), 5, 1,1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1400, super.getMovies().get(2), 5, 1,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1600, super.getMovies().get(2), 5, 3,5, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1800, super.getMovies().get(2), 5, 3,3, MovieFormat.THREE_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(3), 5, 3, 1, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1200, super.getMovies().get(3), 5, 2,6, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1600, super.getMovies().get(3), 5, 2, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(1300, super.getMovies().get(6), 5, 2, 3, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1500, super.getMovies().get(6), 5, 2, 7, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(2200, super.getMovies().get(6), 5, 1,8, MovieFormat.BLOCKBUSTER));
//        showtimeList.add(new ShowTime(1100, super.getMovies().get(7), 5, 1,9, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2200, super.getMovies().get(7), 5, 2, 2, MovieFormat.TWO_DIMENSION));
//        showtimeList.add(new ShowTime(2200, super.getMovies().get(7), 5, 2, 2, MovieFormat.TWO_DIMENSION));
    }
    /**
     * returns the showtimes for the chosen movie
     * @param title input for the title of movie
     * @return showtimes of chosen movie
     */
    private ArrayList<ShowTime> sortMovies(String title){ 
        copyList = new ArrayList<ShowTime>();
        for (ShowTime st: showtimeList){
            if (st.getMovie().contentEquals(title) && (st.getMovieObject().getStatus().getName().equals("Now Showing") || 
            		st.getMovieObject().getStatus().getName().equals("Preview"))){
                copyList.add(st);
            }
        }
        return copyList;
    }
    /**
     * return showtimes for the chosen dates
     * @param date input for the date of the movie
     * @return showtimes of the chosen dates
     */

    private ArrayList<ShowTime> sortDate(String date){ 
        copyList = new ArrayList<ShowTime>();
        for (ShowTime st: showtimeList){
            if (st.toStringGetDate().contentEquals(date) && (st.getMovieObject().getStatus().getName().equals("Now Showing") || 
            		st.getMovieObject().getStatus().getName().equals("Preview"))){
                copyList.add(st);
            }
        }
        return copyList;
    }
    /**
     * search movie by title
     * @param title input for the title of the movie
     * @return a list of showtimes for that particular movie tittle
     */

    public ArrayList<ShowTime> searchByMovie(String title){ 
        return sortMovies(title);
    }

    /**
     * search movie by date in format dd/MM
     * @param date input for the desired date
     * @return a list of showtimes information for that particular date
     */
    public ArrayList<ShowTime> searchByDate(String date){
        return sortDate(date);
    }
    /**
     * 
     * @return current showtimeList
     */
    public ArrayList<ShowTime> getShowTimes(){
    	return showtimeList;
    }
    /**
     * adds showtime to the showtime database
     * @param st input for the showtime to be added in
     */
    public void addSTToDB(ShowTime st) {
    	showtimeList.add(st);
    }
    /**
     * removes showtime from the showtime database
     * @param st input for the showtime to be removed
     */

    public void removeSTToDB(ShowTime st) {
    	if(showtimeList.remove(st)) {
    		st = null;			
    		System.out.println("ShowTime removed");
		}
		else {
			System.out.println("ShowTime does not exist");
		}
    }
}
