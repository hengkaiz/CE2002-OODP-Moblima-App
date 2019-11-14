package user;

import moblima.MenuTemplate;
import user.UserSearchByMovie;
import java.util.Scanner;
import movies.*;

import cinema.ShowTime;

public class UserMainMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public UserMainMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run() {
        Scanner sc = new Scanner(System.in);
        int sel;

        System.out.println("---User Menu---");
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Leave Reviews");
        System.out.println("4. Return");
        System.out.print("Please enter your choice: ");
        boolean loop = true;
        do {
        try {
			sel = sc.nextInt();
			if (sel<0 | sel>4) {
				throw new Exception();
			}
			loop = false;
		} catch (Exception e) {
			System.out.println("Selection Invalid. Try Again.");
		}
        } while (loop);
        System.out.println();
        sc.nextLine(); //clear the buffer

        nextMenu = this;
        switch (sel) {
            case 1: //login menu
                nextMenu = new UserLoginMenu(this);
                break;
            case 2: //create account menu
                break;
            case 3: //user leave reviews
            	Movie mt = UserSearchByMovie.returnMovie(mdb/*main database*/);
            	mt.addReview();

                break;
            case 4: //return
                super.returnPrevious();
        }
        return nextMenu.run();
    }
}
