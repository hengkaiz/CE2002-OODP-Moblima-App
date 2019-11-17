package user;

import booking.BookingMenu;
import moblima.MenuTemplate;

import java.util.Scanner;
/**
 * a menu that lets user view and select the cineplex
 */
public class UserCineplexMenu extends MenuTemplate {
    /**
     * the next menu to run
     */
    private MenuTemplate nextMenu;
    /**
     * menu constructor
     * @param previousMenu points to the previous menu
     */
    public UserCineplexMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }
    /**
     * prints menu options and asks user to pick an option
     * the next menu will be run based on user input
     */
    public MenuTemplate run() {
        Scanner sc = new Scanner(System.in);
        int sel = 0;

        System.out.println("---Choose Cineplex---");
        System.out.println("1. Jurong Point");
        System.out.println("2. Bishan");
        System.out.println("3. Nex");
        System.out.println("4. Return");
        System.out.print("Please enter your choice: ");

        try {
            sel = sc.nextInt();
            if (sel<0 || sel>4) {
                throw new Exception("Error, Input Choice Only From 1-4");
            }
        } catch (Exception e) {
            System.out.println("Invalid Choice. Try Again.");
        }

        nextMenu = this;
        switch(sel){
            case 4: //returns
                super.returnPrevious();
                break;

            case 1: case 2: case 3:// go to search menu
                super.setCineplexNum(sel);
                nextMenu = new BookingMenu(this);
                break;
        }
        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
    }
}
