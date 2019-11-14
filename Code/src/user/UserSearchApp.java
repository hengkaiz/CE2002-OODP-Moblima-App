package user;

import Cinema.ShowTime;
import movies.MovieDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class UserSearchApp {
    public ShowTime showtimelist(MovieDatabase mdb) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ShowTime> copyOfShowTime = null;
        int sel, page_choice = 0;
        ShowTime selected_st = null;

        boolean search_exit = false;
        while (!search_exit) {
            switch (page_choice) {
                case 0: //main page
                    System.out.println("---Search Show times---");
                    System.out.println("1. By Movie");
                    System.out.println("2. By Date");
                    System.out.println("3. Return");
                    System.out.print("Please enter your choice: ");
                    sel = sc.nextInt();
                    if(sel == 3) page_choice = 99; //return to mainApp
                    else if(sel == 1) page_choice = 1;// go to search by movie page
                    else page_choice = 3; //go to search by time page
                    System.out.println();
                    sc.nextLine(); //clear the buffer
                    break;

                case 1: //search by movie page
                    SearchByMovie searchByMovie = new SearchByMovie();
                    copyOfShowTime = searchByMovie.searchApp(mdb);
                    if (copyOfShowTime == null){//return to main page
                        page_choice = 0;
                        break;
                    }

                case 2://print out show times for selected movie
                    System.out.printf("\nShow times for %s\n", copyOfShowTime.get(0).getMovie());
                    for (int i = 0; i < copyOfShowTime.size(); i++) {
                        System.out.printf("%d. %s - %d\n", i + 1, copyOfShowTime.get(i).toStringGetDate(), copyOfShowTime.get(i).getTiming());
                    }
                    System.out.println("-1 to return");
                    System.out.print("Please enter your choice: ");
                    sel = sc.nextInt();
                    System.out.println();
                    sc.nextLine(); //clear the buffer

                    if(sel == -1){
                        page_choice = 1;
                        break;
                    }
                    selected_st = copyOfShowTime.get(sel-1);
                    page_choice = 99; //exit app
                    break;

                case 3: //search by time main page
                    SearchByDate searchByDate = new SearchByDate();
                    copyOfShowTime = searchByDate.searchApp(mdb);
                    if (copyOfShowTime == null){//return to main page
                        page_choice = 0;
                        break;
                    }

                case 4://print out show times for selected movie
                    System.out.printf("\nMovies on %s:\n", copyOfShowTime.get(0).toStringGetDate());
                    for (int i = 0; i < copyOfShowTime.size(); i++) {
                        System.out.printf("%d. %s - %d\n", i + 1, copyOfShowTime.get(i).getMovie(), copyOfShowTime.get(i).getTiming());
                    }

                    System.out.println("-1 to return");
                    System.out.print("Please enter your choice: ");
                    sel = sc.nextInt();
                    System.out.println();
                    sc.nextLine(); //clear the buffer

                    if(sel == -1){
                        page_choice = 1;
                        break;
                    }
                    selected_st = copyOfShowTime.get(sel-1);
                    page_choice = 99; //exit app
                    break;

                default:
                    search_exit = true;
                    break;
            }
        }
        return selected_st;
    }
}
