package admin;

import java.util.Scanner;
import moblima.MenuTemplate;
import movies.ListTopFiveMenu;

public class AdminFunctionsMenu extends MenuTemplate{
	private MenuTemplate nextMenu;
	
	public AdminFunctionsMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		
		System.out.println("---Admin Functions---");
		System.out.println("1. Edit Showtimes");
		System.out.println("2. Edit Movies");
		System.out.println("3. Configure System Settings");
		System.out.println("4. List Top 5 Movies");
		System.out.println("5. Return");
        boolean loop = true;
        do {
        try {
    		System.out.println("Please enter your choice: ");
			sel = sc.nextInt();
			if (sel<1 || sel>5) { //check exceptions?
				throw new Exception();
			}
			loop =false;
		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}
        } while (loop);
        System.out.println();
        nextMenu = this;
      
        switch(sel) {
        case 1: //edit showtimes
        	nextMenu = new AdminShowtimeEditorMenu(this);
			break;
		case 2: //edit movies
			nextMenu = new AdminMovieEditorMenu(this);
			break;
		case 3: //configure system settings
			nextMenu = new AdminConfigureMenu(this);
			break;
		case 4: //list top 5
			nextMenu = new ListTopFiveMenu(this);
			break;
		case 5: //return
			super.returnPrevious();
			break;
        }
        return nextMenu.run();
	}

}
