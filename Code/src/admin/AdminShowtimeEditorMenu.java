package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

public class AdminShowtimeEditorMenu extends MenuTemplate{
	private MenuTemplate nextMenu;
	private int cineplexNum;
	
	public AdminShowtimeEditorMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
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
