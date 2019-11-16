package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

public class AdminUpdateShowtimeMenu extends MenuTemplate{
	private MenuTemplate nextMenu;

	public AdminUpdateShowtimeMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}

	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Select Showtime to update---");
		System.out.println("1. Select by Movie");
		System.out.println("2. Select by Date");
		System.out.println("3. Return");

        try {
        	System.out.println("Please enter your choice:");
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
        }
        return nextMenu.run();
	}
}
