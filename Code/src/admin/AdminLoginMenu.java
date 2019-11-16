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
		
		System.out.println("Enter ID:");
		String ID = sc.nextLine();
		System.out.println("Enter Password:");
		String password = sc.nextLine();
		nextMenu = this;
		if(adminLoginApp.loginCheck(ID, password)) { //login successful
			super.setUsername(ID);
			System.out.println("Welcome, " + ID + "\n");
			nextMenu = new AdminCineplexMenu(super.previousMenu);			
		}
		else {
			System.out.println("Invalid Admin. Try Again.");
		}
		return nextMenu.run();
	}

}
