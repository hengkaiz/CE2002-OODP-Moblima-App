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

    public UserSearchApp(){
        mdb = saveAndLoadDB.loadMovieDB();
        stdb = saveAndLoadDB.loadShowTimeDB();
    }

    public ShowTime SearchByMovie() {
        Scanner sc = new Scanner(System.in);
        int sel;

        UserSearchByMovie searchByMovie = new UserSearchByMovie();
        copyOfShowTime = searchByMovie.searchApp(mdb);

        if (copyOfShowTime == null) return null;//return to search menu

        System.out.printf("\nShow times for %s\n", copyOfShowTime.get(0).getMovie());
        for (int i = 0; i < copyOfShowTime.size(); i++) {
            System.out.printf("%d. %s - %d\n", i + 1, copyOfShowTime.get(i).toStringGetDate(), copyOfShowTime.get(i).getTiming());
        }
        System.out.println("-1 to return");
        System.out.print("Please enter your choice: ");

        sel = sc.nextInt();
        System.out.println();
        sc.nextLine(); //clear the buffer

        if (sel == -1) return null; // return to search menu

        return copyOfShowTime.get(sel - 1);
    }

    public ShowTime SearchByDate(){
        Scanner sc = new Scanner(System.in);
        int sel;

        UserSearchByDate searchByDate = new UserSearchByDate();
        copyOfShowTime = searchByDate.searchApp(mdb);

        if (copyOfShowTime == null) return null;//return to search menu

        System.out.printf("\nMovies on %s:\n", copyOfShowTime.get(0).toStringGetDate());
        for (int i = 0; i < copyOfShowTime.size(); i++) {
            System.out.printf("%d. %s - %d\n", i + 1, copyOfShowTime.get(i).getMovie(), copyOfShowTime.get(i).getTiming());
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
