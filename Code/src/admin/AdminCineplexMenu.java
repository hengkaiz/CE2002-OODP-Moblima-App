package admin;

import java.util.Scanner;
import moblima.MenuTemplate;

/**
 * Menu to choose Cineplex number.
 * Provides Cineplex options available.
 */
public class AdminCineplexMenu extends MenuTemplate{
	
	/**
	 * The next menu to run.
	 */
	private MenuTemplate nextMenu;

	/**
	 * Menu constructor.
	 * @param previousMenu Points to the previous menu
	 */
	public AdminCineplexMenu(MenuTemplate previousMenu) {
		super(previousMenu);
	}
	
	/**
	 * Prints cineplex options and asks for admin input.
	 * Admin can also choose to return to previous menu.
	 * @return The next menu will be run based on user input.
	 */
	public MenuTemplate run() {
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		
		System.out.println("---Choose Cineplex that you work for---");
        System.out.println("1. Jurong Point");
        System.out.println("2. Bishan");
        System.out.println("3. Nex");
        System.out.println("4. Return");

        try {
            System.out.print("Please enter your choice: ");
            sel = sc.nextInt();
            if (sel<1 || sel>4) { //check exceptions
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid Choice. Try Again.");
            return this.run();
            }

        System.out.println();
        nextMenu = this;
        switch(sel) {
        case 4: //return
        	super.returnPrevious();
        	break;
        default: //go straight to AdminFunctionsMenu
        	super.setCineplexNum(sel);
        	nextMenu = new AdminFunctionsMenu(this);
        	break;
        }
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
	}

}
