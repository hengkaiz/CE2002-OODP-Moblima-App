package user;

import booking.BookingMenu;
import moblima.MenuTemplate;

import java.util.Scanner;

public class UserCineplexMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public UserCineplexMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run() {
        Scanner sc = new Scanner(System.in);
        int sel = 0;

        System.out.println("---Choose Cineplex---");
        System.out.println("1. Jurong Point");
        System.out.println("2. Bishan");
        System.out.println("3. Nex");
        System.out.println("4. Return");
        System.out.print("Please enter your choice: ");
        boolean loop = true;
        do {
            try {
                sel = sc.nextInt();
                if (sel<0 || sel>4) {
                    throw new Exception("Error, Input Choice Only From 1-4");
                }
                loop =false;
            } catch (Exception e) {
                System.out.println("Invalid Choice. Try Again.");
            }
        } while (loop);
        UserSearchApp userSearchApp = new UserSearchApp(super.getCineplexNum());

        nextMenu = this;
        switch(sel){
            case 4: //returns
                super.returnPrevious();
                break;

            default:// go to search menu
                super.setCineplexNum(sel);
                nextMenu = new BookingMenu(this);
                break;
        }
        return nextMenu.run();
    }
}
