package user;

import Cinema.ShowTime;
import movies.MovieDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSearchApp {
    public ShowTime showtimelist(MovieDatabase mdb) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ShowTime> copyOfShowTime;
        int sel;
        ShowTime selected_st = null;

        //boolean search_exit = false;
        //while (!search_exit) {
        System.out.println("---Search Show times---");
        System.out.println("1. By Movie");
        System.out.println("2. By Date");
        System.out.println("3. Return");
        System.out.print("Please enter your choice: ");
        sel = sc.nextInt();
        System.out.println();
        sc.nextLine(); //clear the buffer

        switch (sel) {
            case 1:
                SearchByMovie searchByMovie = new SearchByMovie();
                copyOfShowTime = searchByMovie.searchApp(mdb);

                //print out show times for selected movie
                System.out.printf("\nShow times for %s\n", copyOfShowTime.get(0).getMovie());
                for (int i=0; i<copyOfShowTime.size();i++){
                    System.out.printf("%d. %d\n", i+1, copyOfShowTime.get(i).getTiming());
                }

                System.out.print("Please enter your choice: ");
                sel = sc.nextInt() - 1;
                System.out.println();
                sc.nextLine(); //clear the buffer

                selected_st = copyOfShowTime.get(sel);
                break;

            case 2:
                SearchByDate searchByDate = new SearchByDate();
                copyOfShowTime = searchByDate.searchApp(mdb);

                //print out show times for selected movie
                System.out.printf("\nMovies on %s:", copyOfShowTime.get(0).getDate());
                for (int i=0; i<copyOfShowTime.size();i++){
                    System.out.printf("%d. %s - %d", i+1, copyOfShowTime.get(i).getMovie(), copyOfShowTime.get(i).getTiming());
                }

                System.out.print("Please enter your choice: ");
                sel = sc.nextInt() - 1;
                System.out.println();
                sc.nextLine(); //clear the buffer

                selected_st = copyOfShowTime.get(sel);
                break;

            case 3:
                selected_st = null;
                break;
        }
        return selected_st;
    }
}
