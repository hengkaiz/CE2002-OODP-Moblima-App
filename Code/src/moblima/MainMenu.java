package moblima;

import user.UserMainMenu;
import admin.AdminMainMenu;

import java.util.Scanner;
/**
 * represents the main menu 
 *
 */
public class MainMenu extends MenuTemplate {
	/**
	 * The next menu to run
	 */
    private MenuTemplate nextMenu;
    
    /**
     * menu constructor
     * @param previousMenu points to the previous menu
     */
    public MainMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }
    /**
     * constructor for main menu
     */
    public MainMenu(){}
    /**
     * prints menu options and asks user to pick an option
	 * the next menu will be run based on user input
     */

    public MenuTemplate run(){
        Scanner sc = new Scanner(System.in);
        int sel = 0;

        System.out.println("\n---MOBLMIA---");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.println("3. Exit");
        System.out.print("Please enter your choice: ");

        try {
			sel = sc.nextInt();
			if (sel<1 || sel >3) {
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("Invalid Selection. Try again.");
		}
        sc.nextLine(); //clear the buffer

        nextMenu = this;

        switch(sel) {
            case 1: //user login page
                nextMenu = new UserMainMenu(this);
                break;
            case 2: //admin login page
                nextMenu = new AdminMainMenu(this);
                break;
            case 3:
                System.exit(0);
        }
        return nextMenu.run();
    }
}
