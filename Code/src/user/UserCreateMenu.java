package user;

import moblima.MenuTemplate;

import java.util.Scanner;

public class UserCreateMenu extends MenuTemplate{
        private MenuTemplate nextMenu;

        public UserCreateMenu(MenuTemplate previousMenu) {
            super(previousMenu);
        }

        public MenuTemplate run(){ //create new account
            nextMenu = this;
            Scanner sc = new Scanner(System.in);
            UserLoginApp userLoginApp = new UserLoginApp();

            System.out.print("Enter desired ID: ");
            boolean loop = true;
            do {
            try {
				String dID = sc.nextLine();
				if(userLoginApp.checkID(dID)){ //username does not exist
				    System.out.print("Enter desired Password: ");
				    String dPassword = sc.nextLine();
				    System.out.print("Please retype your Password: ");
				    String dPassword2 = sc.nextLine();
				    if (!dPassword.contentEquals(dPassword2)) {
				        throw new Exception("The passwords do not match, please try again!");
				    }

				    userLoginApp.addUser(dID, dPassword2);
				    System.out.print("Welcome, " + dID + "\n");

				    nextMenu = new UserCineplexMenu(super.previousMenu);
				    loop = false;
				}
			} catch (Exception e) {
				System.out.println("Input Error. Try Again.");
			}
            } while (loop);

            return nextMenu.run();
        }
}
