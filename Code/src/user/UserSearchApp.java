package user;

import cinema.ShowTime;
import cinema.ShowTimeDatabase;
import moblima.SaveAndLoadDB;
import movies.MovieDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSearchApp {
    private MovieDatabase mdb;
    private ShowTimeDatabase stdb;
    private SaveAndLoadDB saveAndLoadDB = new SaveAndLoadDB();
    private ShowTime selST;
    private ArrayList<ShowTime> copyOfShowTime;
    private int cineplexNumber;

    public UserSearchApp(int cineplexNumber){
        this.cineplexNumber = cineplexNumber;
        mdb = saveAndLoadDB.loadMovieDB();
        stdb = saveAndLoadDB.loadShowTimeDB(this.cineplexNumber);
    }

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
        	System.out.printf("%d. %s - %d - %s - %s\n", i + 1, copyOfShowTime.get(i).toStringGetDate(), copyOfShowTime.get(i).getTiming()
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
