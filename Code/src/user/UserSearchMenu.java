package user;

import cinema.ShowTime;
import moblima.MenuTemplate;
import movies.MovieDatabase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserSearchMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public UserSearchMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run() {
        Scanner sc = new Scanner(System.in);
        ShowTime copyOfSelShowTime;
        int sel = 0;

        System.out.println("---Search Show times---");
        System.out.println("1. By Movie");
        System.out.println("2. By Date");
        System.out.println("3. Top 5 Movies");
        System.out.println("4. Return");
        System.out.print("Please enter your choice: ");
        boolean loop = true;
        do {
        try {
			sel = sc.nextInt();
			if (sel<0 || sel>4) {
				throw new Exception("Error, Input Choice Only From 1-4");
			}
			loop =false;
		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}
        } while (loop);
        UserSearchApp userSearchApp = new UserSearchApp(super.getCineplexNum());

        nextMenu = this;
        switch(sel){
            case 1: //calls search by movie
                ShowTime selST = userSearchApp.SearchByMovie();
                if (selST != null) nextMenu = new UserChooseSeatsMenu(this, selST);
                break;

            case 2: //calls search by date
                ShowTime selST2 = userSearchApp.SearchByDate();
                if (selST2 != null) nextMenu = new UserChooseSeatsMenu(this, selST2);
                break;

            case 3: //list top 5 movies
                /*MovieDatabase mdb = new MovieDatabase();
                mdb.printTop5();*/
                
            case 4: //returns
                super.returnPrevious();
        }
        return nextMenu.run();
    }
}
