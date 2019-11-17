package admin;

import moblima.MenuTemplate;
import java.util.Scanner;

/**
 * Main Menu for admin.
 */
public class AdminMainMenu extends MenuTemplate{
	
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;
	
	/**
	 * Menu constructor.
	 * @param previousMenu Points to the previous menu
	 */
	public AdminMainMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	/**
	 * Prints main menu options and asks admin to pick an option.
	 * To access any of the admin functions, admin has to first log in successfully.
	 * @return The next menu will be run based on admin input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Admin Main Menu---");
		System.out.println("1. Login");
		System.out.println("2. Return");

        try {
    		System.out.print("Please enter your choice: ");
			sel = sc.nextInt();
			if (sel<1 || sel>2) { 
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid choice. Try Again.");
		}

        System.out.println();
        sc.nextLine(); //clear the buffer
        
        nextMenu = this;
        switch(sel) {
        case 1: //login
        	nextMenu = new AdminLoginMenu(this);
        	break;
        case 2: //return
        	super.returnPrevious();
		default:
			break;
        }
        return nextMenu.run();
	}

}
