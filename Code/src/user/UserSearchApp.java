package user;

import cinema.ShowTime;
import cinema.ShowTimeDatabase;
import moblima.SaveAndLoadDB;
import movies.MovieDatabase;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * search showtime by title and date
 */
public class UserSearchApp {
    /**
     * object reference to load the actual movie database on to mdb
     */
    private MovieDatabase mdb;
    /**
     * object reference to load the actual showtime database on to stdb
     */
    private ShowTimeDatabase stdb;
    /**
     * Allows saving and loading of the actual database to and from a local copy
     */
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
    /**
     * ShowTime object
     */
    private ShowTime selST;
    /**
     * ArrayList of ShowTime objects
     */
    private ArrayList<ShowTime> copyOfShowTime;
    /**
     * cineplex number
     */
    private int cineplexNumber;
    /**
     * constructs a UserSearchApp object
     * @param cineplexNumber is the cineplex number
     */
    public UserSearchApp(int cineplexNumber){
        this.cineplexNumber = cineplexNumber;
        mdb = saveAndLoadDB.loadMovieDB();
        stdb = saveAndLoadDB.loadShowTimeDB(this.cineplexNumber);
    }
    /**
     * searches for the showtime by title
     * @return the found ShowTime
     */
    public ShowTime SearchByMovie() {
        Scanner sc = new Scanner(System.in);
        int sel=0;

        UserSearchByMovie searchByMovie = new UserSearchByMovie();
        try {
            copyOfShowTime = searchByMovie.searchApp(mdb, cineplexNumber);
        }
        catch(Exception e){
            System.out.println("Invalid input!");
            return null;
        }
        if (copyOfShowTime == null) return null;//return to search menu

        System.out.printf("\nShow times for %s\n", copyOfShowTime.get(0).getMovie());
        for (int i = 0; i < copyOfShowTime.size(); i++) {
            System.out.printf("%d. %s - %d - %s - %s\n", i + 1, copyOfShowTime.get(i).toStringGetDate(), copyOfShowTime.get(i).getTiming()
            		, copyOfShowTime.get(i).getCinemaType(), copyOfShowTime.get(i).getMovieFormat().getName());
        }
        System.out.println("-1 to return");
        try {
            System.out.print("Please enter your choice: ");

            sel = sc.nextInt();
            System.out.println();
            sc.nextLine(); //clear the buffer
        }
        catch (Exception e) {
            System.out.println("\nInvalid option. Try Again.");
            return null;
        }

        if (sel == -1) return null; // return to search menu

        return copyOfShowTime.get(sel - 1);
    }
    /**
     * searches for the showtime by date
     * @return the found ShowTime
     */
    public ShowTime SearchByDate(){
        Scanner sc = new Scanner(System.in);
        int sel;

        UserSearchByDate searchByDate = new UserSearchByDate();
        try {
            copyOfShowTime = searchByDate.searchApp(mdb, cineplexNumber);
        }
        catch(Exception e){
            System.out.println("Invalid input!");
            return null;
        }

        if (copyOfShowTime == null) return null;//return to search menu

        System.out.printf("\nMovies on %s:\n", copyOfShowTime.get(0).toStringGetDate());
        for (int i = 0; i < copyOfShowTime.size(); i++) {
        	System.out.printf("%d. %s - %d - %s - %s\n", i + 1, copyOfShowTime.get(i).getMovie(),
                    copyOfShowTime.get(i).getTiming()
            		, copyOfShowTime.get(i).getCinemaType(), copyOfShowTime.get(i).getMovieFormat().getName());
        }

        System.out.println("-1 to return");
        System.out.print("Please enter your choice: ");

        sel = sc.nextInt();
        System.out.println();
        sc.nextLine(); //clear the buffer

        if(sel == -1) return null; //return to search menu

        return copyOfShowTime.get(sel-1);
    }

}
