package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

public class ShowtimeEditorMenu extends MenuTemplate{
	private MenuTemplate nextMenu;
	
	public ShowtimeEditorMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Edit Showtimes---");
		System.out.println("1. Create Showtime");
		System.out.println("2. Update Showtime");
		System.out.println("3. Remove Showtime");
		System.out.println("4. Return");
		boolean loop = true;
        do {
        try {
			sel = sc.nextInt();
			if (sel<0 || sel>4) { //check exceptions?
				throw new Exception("Error, Input Choice Only From 1-4");
			}
			loop =false;
		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}
        } while (loop);
        nextMenu = this;
        //ShowtimeEditorApp showtimeEditorApp = new ShowtimeEditorApp(super.getCineplexNum());
        CinemaShowtimesAndMovieEditor csme = new CinemaShowtimesAndMovieEditor();
        
        switch(sel) {
        case 1: //create showtime
        	csme.createCinemaShowtimesAndMovie();
        	break;
        case 2: //update showtime
        	break;
        case 3: //remove showtime
        	break;
        case 4: //return
        	super.returnPrevious()
        	break;
        }
        
	}

}
