package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

/**
 * Menu to choose options for editing showtimes.
 * Provides editing options available.
 */
public class AdminShowtimeEditorMenu extends MenuTemplate{
	
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;
	
	/**
	 * Specified cineplex number.
	 */
	private int cineplexNum;
	
	/**
	 * Menu constructor
	 * @param previousMenu points to the previous menu
	 */
	public AdminShowtimeEditorMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	/**
	 * Prints editing options and asks for admin input.
	 * Admin can also choose to return to previous menu.
	 * @return The next menu will be run based on user input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel = 0;

		System.out.println("---Edit Showtimes---");
		System.out.println("1. Create Showtime");
		System.out.println("2. Update Showtime");
		System.out.println("3. Remove Showtime");
		System.out.println("4. Return");

		try {
			System.out.println("Please enter your choice:");
			sel = sc.nextInt();
			if (sel < 1 || sel > 4) { 
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}
		nextMenu = this;
        System.out.println();
		AdminShowtimeEditor stEditor = new AdminShowtimeEditor(super.getCineplexNum());

		switch (sel) {
			case 1: //create showtime
				int cinemaNum = stEditor.cinemaSelection();
				if(cinemaNum==-1) {
					break;
				}
				stEditor.createShowtimes(cinemaNum);
				break;
			case 2: //update showtime
				nextMenu = new AdminUpdateShowtimeMenu(this);
				break;
			case 3: //remove showtime
				stEditor.removeShowtimes();
				break;
			case 4: //return
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
