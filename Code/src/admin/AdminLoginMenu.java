package admin;

import moblima.MenuTemplate;
import java.util.Scanner;

public class AdminLoginMenu extends MenuTemplate{
	private MenuTemplate nextMenu;
	
	public AdminLoginMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
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
		return nextMenu.run();
	}

}
