package movies;

import java.util.Scanner;
import moblima.MenuTemplate;

public class ListTopFiveMenu extends MenuTemplate{
	private MenuTemplate nextMenu;
	
	public ListTopFiveMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---List Top 5 Movies---");
		System.out.println("1. By Overall Rating");
		System.out.println("2. By Ticket Sales");
		System.out.println("3. Return");
		boolean loop = true;
		do {
			try {
				sel = sc.nextInt();
				if (sel < 0 || sel > 4) { //check exceptions?
					throw new Exception();
				}
				loop = false;
			} catch (Exception e) {
				System.out.println("Invalid Choice. Try Again.");
			}
		} while (loop);
		nextMenu = this;
		ListTopFiveApp listTop = new ListTopFiveApp();
		
		switch(sel) {
		case 1: //by overall rating
			listTop.printTopByOverallRating();
			break;
		case 2: //by total sales
			listTop.printTopByTotalSales();
			break;
		case 3: //return
			super.returnPrevious();
			break;
		}
		return nextMenu.run();
	}
}
