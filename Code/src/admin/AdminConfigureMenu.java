package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

/**
 * Menu to choose which system setting to configure.
 * Provides which system settings are available for configuration.
 */
public class AdminConfigureMenu extends MenuTemplate{
	
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;
	
	/**
	 * Menu constructor.
	 * @param previousMenu Points to the previous menu
	 */
	public AdminConfigureMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	/**
	 * Prints system settings available for configuration and asks for admin input.
	 * Admin can also choose to return to previous menu.
	 * @return The next menu will be run based on user input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel=0;
		
		System.out.println("---Configure System Settings---");
		System.out.println("1. Update Ticket Prices");
		System.out.println("2. Update Holidays");
		System.out.println("3. Reset");
		System.out.println("4. Return");

		try {
			System.out.print("Please enter your choice: ");
			sel = sc.nextInt();
			if (sel < 1 || sel > 4) { //check exceptions
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("Invalid Choice. Try Again.");
		}

		System.out.println();
		nextMenu = this;
		AdminConfigureSystemSettings configureSS = new AdminConfigureSystemSettings();
		
		switch(sel) {
		case 1: //update ticket price
			configureSS.updateTicketPrice();
			break;
		case 2: //update holidays
			configureSS.updateHolidays();
			break;
		case 3: //reset
			configureSS.resetSettings();
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
