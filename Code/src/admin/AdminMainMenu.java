package admin;

import moblima.MenuTemplate;
import java.util.Scanner;

public class AdminMainMenu extends MenuTemplate{
	private MenuTemplate nextMenu;
	
	public AdminMainMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Admin Menu---");
		System.out.println("1. Login");
		System.out.println("2. Return");
		System.out.println("Please enter your choice: ");
        boolean loop = true;
        do {
        try {
			sel = sc.nextInt();
			if (sel<1 || sel>2) { //check exceptions?
				throw new Exception();
			}
			loop = false;
		} catch (Exception e) {
			System.out.println("Selection Invalid. Try Again.");
		}
        } while (loop);
        System.out.println();
        sc.nextLine(); //clear the buffer
        
        nextMenu = this;
        switch(sel) {
        case 1: //login
        	nextMenu = new AdminLoginMenu(this);
        	break;
        case 2: //return
        	super.returnPrevious();
        }
        return nextMenu.run();
	}

}
