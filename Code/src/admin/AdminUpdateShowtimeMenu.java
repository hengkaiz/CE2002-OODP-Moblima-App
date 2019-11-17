package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

/**
 * Menu to choose options for updating showtimes.
 * Provides updating options available.
 */
public class AdminUpdateShowtimeMenu extends MenuTemplate{
	
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;

	/**
	 * Menu constructor
	 * @param previousMenu points to the previous menu
	 */
	public AdminUpdateShowtimeMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	/**
	 * Prints updating options and asks for admin input.
	 * Admin can also choose to return to previous menu.
	 * @return The next menu will be run based on user input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Select Showtime to update---");
		System.out.println("1. Select by Movie");
		System.out.println("2. Select by Date");
		System.out.println("3. Return");

        try {
        	System.out.print("Please enter your choice:");
			sel = sc.nextInt();
			if (sel<1 || sel>3) {
				throw new Exception("");
			}
		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}
        System.out.println();
        nextMenu = this;
        AdminShowtimeEditor stEditor = new AdminShowtimeEditor(super.getCineplexNum());
        
        switch(sel) {
        case 1: //select by movie
        	stEditor.updateByMovie();
        	break;
        case 2: //select by date
        	stEditor.updateByDate();
        	break;
        case 3: //return
        	super.returnPrevious();
        	break;
		default:
			break;
        }
        return nextMenu.run();
	}
}
