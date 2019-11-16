package user;

import moblima.MenuTemplate;

import java.util.Scanner;

public class UserLoginMenu extends MenuTemplate {
    private MenuTemplate nextMenu;

    public UserLoginMenu(MenuTemplate previousMenu) {
        super(previousMenu);
    }

    public MenuTemplate run(){
        Scanner sc = new Scanner(System.in);
        UserLoginApp userLoginApp = new UserLoginApp();
        String ID = null;
        String Password = null;
        String username;

        try {
	        System.out.print("Enter ID: ");
	        ID = sc.nextLine();
	        
	        System.out.print("Enter password: ");
	        Password = sc.nextLine();
        }
        catch (Exception e) {
        	System.out.println("Invalid ID/Password. Try Again");
        }
        
        nextMenu = this;

        username = userLoginApp.loginCheck(ID, Password);
        if (!username.contentEquals("")) { //login successful
            super.setUsername(username);
            System.out.println("Welcome, " + ID + "\n");
            nextMenu = new UserCineplexMenu(super.previousMenu);
        }

        nextMenu.setCineplexNum(super.getCineplexNum());
        nextMenu.setUsername(super.getUsername());
        return nextMenu.run();
    }
}
