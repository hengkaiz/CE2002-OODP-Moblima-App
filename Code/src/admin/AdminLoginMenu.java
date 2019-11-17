package admin;

import moblima.MenuTemplate;
import java.util.Scanner;

/**
 * Menu for admin to enter ID and password.
 */
public class AdminLoginMenu extends MenuTemplate{
	
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;
	
	/**
	 * Menu constructor.
	 * @param previousMenu Points to the previous menu
	 */
	public AdminLoginMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	/**
	 * Gets admin ID and password from admin trying to log in.
	 * Passes in the admin ID and password as arguments for login check.
	 * Stores the return value of login check.
	 * If true, admin is allowed access to the next menu.
	 * if false, admin is disallowed access and is brought back to the previous menu.
	 * @return The next menu will be run based on user input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		AdminLoginApp adminLoginApp = new AdminLoginApp();
		
		String ID = null;
		String password = null;
		try {
			System.out.println("Enter ID:");
			ID = sc.nextLine();
			System.out.println("Enter Password:");
			password = sc.nextLine();
		} catch (Exception e) {
			System.out.println("Invalid input for ID/Password. Try Again.");
		}

		nextMenu = this;
		if(adminLoginApp.loginCheck(ID, password)) { //login successful
			super.setUsername(ID);
			System.out.println("Welcome, " + ID + "\n");
			nextMenu = new AdminCineplexMenu(super.previousMenu);			
		}
		else {
			System.out.println("Invalid Admin. Try Again.");
			super.returnPrevious();
		}
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
	}

}
