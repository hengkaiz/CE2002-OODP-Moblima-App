package moblima;

import user.UserMainMenu;

import java.util.Scanner;

public class MainMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public MainMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MainMenu(){}

    public MenuTemplate run(){
        Scanner sc = new Scanner(System.in);
        int sel;

        System.out.println("---MOBLMIA---");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.println("3. Exit");
        System.out.print("Please enter your choice: ");
        sel = sc.nextInt();
        System.out.println();
        sc.nextLine(); //clear the buffer

        nextMenu = this;

        switch(sel) {
            case 1: //user login page
                nextMenu = new UserMainMenu(this);
                break;
            case 2: //admin login page
                //nextMenu = new AdminMainMenu(this);
                break;
            case 3:
                System.exit(0);
        }
        return nextMenu.run();
    }
}
