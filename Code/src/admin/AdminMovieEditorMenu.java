package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

public class AdminMovieEditorMenu extends MenuTemplate{
	private MenuTemplate nextMenu;
	
	public AdminMovieEditorMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}

	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Edit Movies---");
		System.out.println("1. Create Movies");
		System.out.println("2. Update Movies");
		System.out.println("3. Remove Movies");
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
		case 4: //return
			super.returnPrevious();
			break;
		}
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
	}
}
