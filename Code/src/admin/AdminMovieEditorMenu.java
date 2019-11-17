package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

/**
 * Menu to choose options for editing movie listings.
 * Provides editing options available.
 */
public class AdminMovieEditorMenu extends MenuTemplate{
	
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;
	
	/**
	 * Menu constructor
	 * @param previousMenu points to the previous menu
	 */
	public AdminMovieEditorMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}

	/**
	 * Prints editing options and asks for admin input.
	 * Admin can also choose to return to previous menu.
	 * @return The next menu will be run based on user input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Edit Movies---");
		System.out.println("1. Create Movies");
		System.out.println("2. Update Movies");
		System.out.println("3. Remove Movies");
		System.out.println("4. See Current Movie Details");
		System.out.println("5. Return");

		try {
			System.out.println("Please enter your choice:");
			sel = sc.nextInt();
			if (sel < 1 || sel > 5) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}
		System.out.println();
		nextMenu = this;
		AdminMovieEditor mEditor = new AdminMovieEditor(super.getCineplexNum());
				
		switch(sel) {
		case 1: //create
			mEditor.createMovieListing();
			break;
		case 2: //update
			mEditor.updateMovieListing();
			break;
		case 3: //remove
			mEditor.removeMovieListing();
			break;
		case 4: //see movies
			mEditor.seeMovie();
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
