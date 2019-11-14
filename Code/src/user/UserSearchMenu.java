package user;

import cinema.ShowTime;
import moblima.MenuTemplate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserSearchMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public UserSearchMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run(){
        Scanner sc = new Scanner(System.in);
        ShowTime copyOfSelShowTime;
        int sel;

        System.out.println("---Search Show times---");
        System.out.println("1. By Movie");
        System.out.println("2. By Date");
        System.out.println("3. Return");
        System.out.print("Please enter your choice: ");
        sel = sc.nextInt();

        UserSearchApp userSearchApp = new UserSearchApp();

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

            case 3: //returns
                super.returnPrevious();
        }
        return nextMenu.run();
    }
}
