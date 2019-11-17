package movies;

import java.util.Scanner;
import moblima.MenuTemplate;
/**
 * a menu that lets user pick a category to list the top 5 movies
 */
public class ListTopFiveMenu extends MenuTemplate{
	/**
	 * the next menu to run
	 */
	private MenuTemplate nextMenu;
	
	/**
	 * menu constructor
	 * @param previousMenu points to the previous menu
	 */
	public ListTopFiveMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	/**
	 * asks user to pick a category to list top 5 movies
	 * user can also choose to return to the previous menu
	 * @return the next menu will be run based on user input
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("\n---List Top 5 Movies---");
		System.out.println("1. By Overall Rating");
		System.out.println("2. By Ticket Sales");
		System.out.println("3. Return");

		try {
			sel = sc.nextInt();
			if (sel < 0 || sel > 4) { //check exceptions?
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}

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
