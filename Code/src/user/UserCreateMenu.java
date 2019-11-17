package user;

import moblima.MenuTemplate;

import java.sql.SQLOutput;
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

            System.out.print("\nEnter desired ID: ");
            try{
				String dID = sc.nextLine();
				if(userLoginApp.checkID(dID)){ //username does not exist
				    System.out.print("Enter desired Password: ");
				    String dPassword = sc.nextLine();
				    System.out.print("Please retype your Password: ");
				    String dPassword2 = sc.nextLine();
				    if (!dPassword.contentEquals(dPassword2)) {
				        throw new Exception("\nThe passwords do not match, please try again!");
				    }

				    userLoginApp.addUser(dID, dPassword2);
				    System.out.print("Welcome, " + dID + "\n");
					super.setUsername(dID);
				    nextMenu = new UserCineplexMenu(super.previousMenu);
				}
				else{
					System.out.println("\nID already exist!");
					super.returnPrevious();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				super.returnPrevious();
			}

			nextMenu.setCineplexNum(super.getCineplexNum());
			nextMenu.setUsername(super.getUsername());
            return nextMenu.run();
        }
}
