package admin;

import java.util.Scanner;
import moblima.MenuTemplate;
import movies.ListTopFiveMenu;

/**
 * Menu to choose Admin Functions.
 * Provides Admin Functions available.
 */
public class AdminFunctionsMenu extends MenuTemplate{
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;
	
	/**
	 * Menu constructor
	 * @param previousMenu points to the previous menu
	 */
	public AdminFunctionsMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	/**
	 * Prints admin functions options and asks for admin input.
	 * Admin can also choose to return to previous menu.
	 * @return The next menu will be run based on user input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
	
		System.out.print("---Admin Functions for ");
        if(super.getCineplexNum() == 1) System.out.printf("Jurong Point Cineplex---\n");
        else if (super.getCineplexNum() == 2) System.out.printf("Bishan Cineplex---\n");
        else System.out.printf("Nex Cineplex---\n");
		System.out.println("1. Edit Showtimes");
		System.out.println("2. Edit Movies");
		System.out.println("3. Configure System Settings");
		System.out.println("4. List Top 5 Movies");
		System.out.println("5. Return");

        try {
    		System.out.print("Please enter your choice: ");
			sel = sc.nextInt();
			if (sel<1 || sel>5) { 
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}
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
		default:
			break;
        }
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
	}

}
